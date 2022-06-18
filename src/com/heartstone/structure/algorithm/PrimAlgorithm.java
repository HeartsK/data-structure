package com.heartstone.structure.algorithm;

import java.util.Arrays;

public class PrimAlgorithm {

    public static void main(String[] args) {
        PTree tree = new PTree();
        int vertex = 7;
        String[] data = new String[]{"A","B","C","D","E","F","G"};
        int[][] matrix = new int[][]{
                {1000,5,7,1000,1000,1000,2},
                {5,1000,1000,9,1000,1000,3},
                {7,1000,1000,1000,8,1000,1000},
                {1000,9,1000,1000,1000,4,1000},
                {1000,1000,8,1000,1000,5,4},
                {1000,1000,1000,4,5,1000,6},
                {2,3,1000,1000,4,6,1000},
        };
        PGraph graph = tree.createGraph(vertex, data, matrix);
        tree.showGraph(graph);
        tree.prim(0,graph);
    }

}

//图树
class PTree{

    /**
     * 创建图
     * @param vertex 顶点数
     * @param data 顶点值
     * @param matrix 邻接矩阵
     */
    public PGraph createGraph(int vertex, String[] data, int[][] matrix){
        PGraph graph = new PGraph(vertex);
        graph.setData(data);
        graph.setMatrix(matrix);
        return graph;
    }

    public void showGraph(PGraph graph){
        for (int[] matrix : graph.getMatrix()) {
            System.out.println(Arrays.toString(matrix));
        }
    }

    /**
     * 普利姆算法求最小生成树
     * @param v 从哪个顶点开始
     * @param graph 图
     */
    public void prim(int v, PGraph graph){
        int[] isVisited = new int[graph.getVertex()];
        //用来记录对比顶点
        isVisited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        //最外层循环代表七个顶点只需要六条边即可联通
        for (int k = 1; k < graph.getData().length; k++) {
            int minWeight = 1000;
            for (int i = 0; i < graph.getVertex(); i++) {
                for (int j = 0; j < graph.getVertex(); j++) {
                    //从一个已访问的顶点到另一个未访问的顶点的边的权重是否最小
                    if (isVisited[i] == 1 && isVisited[j] ==0 && graph.getMatrix()[i][j] < minWeight){
                        minWeight = graph.getMatrix()[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("<"+graph.getData()[h1]+"->"+graph.getData()[h2]+"> weight:" + graph.getMatrix()[h1][h2]);
            isVisited[h2] = 1;
        }
    }
}

//图
class PGraph{
    //顶点数
    private int vertex;
    //存放顶点数据
    private String[] data;
    //邻接矩阵
    private int[][] matrix;

    public PGraph(int vertex){
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
