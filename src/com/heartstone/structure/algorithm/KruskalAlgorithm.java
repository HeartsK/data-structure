package com.heartstone.structure.algorithm;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法求最小生成树
 */
public class KruskalAlgorithm {

    //顶点数
    public static int vertex;
    //存放顶点数据
    public static char[] data;
    //邻接矩阵
    public static int[][] matrix;
    //不连通的顶点间邻接矩阵的值
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        vertex = 7;
        data = new char[]{'A','B','C','D','E','F','G'};
        matrix =new int[][]{
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        Kruskal kruskal = new Kruskal();
        int edgeNum = kruskal.getEdgeNum(matrix, INF);
//        System.out.println(edgeNum);
        Edge[] edges = kruskal.getEdges(matrix, edgeNum, INF, data);
//        System.out.println(Arrays.toString(edges));
        kruskal.edgeSortByWeight(edges);
//        System.out.println(Arrays.toString(edges));
        Edge[] select = kruskal.kruskal(edgeNum, vertex, edges, data);
        System.out.println(Arrays.toString(select));
    }
}

class Kruskal{

    public Edge[] kruskal(int edgeNum, int vertex, Edge[] edges, char[] data){
        Edge[] select = new Edge[edgeNum];
        int index = 0;
        int[] ends = new int[vertex];
        for (Edge edge : edges) {
            int startIndex = getIndexByChar(edge.start, data);
            int endIndex = getIndexByChar(edge.end, data);
            int m = getEndIndex(startIndex, ends);
            int n = getEndIndex(endIndex, ends);
            if (m!=n){
                select[index++] = edge;
                ends[m] = n;
            }
        }
        return select;
    }

    //获取连通边的值
    public int getEdgeNum(int[][] matrix, int INF){
        int edgeNum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
        return edgeNum;
    }

    //获取传入顶点的终点
    public int getEndIndex(int i, int[] ends){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

    //获取顶点下标
    public int getIndexByChar(char c, char[] data){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c){
                return i;
            }
        }
        return -1;
    }

    //创建边的集合
    public Edge[] getEdges(int[][] matrix, int edgeNum, int INF, char[] data){
        Edge[] edges = new Edge[edgeNum];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                if (matrix[i][j] != INF) {
                    Edge edge = new Edge(data[i],data[j],matrix[i][j]);
                    edges[index++] = edge;
                }
            }
        }
        return edges;
    }

    //按找权值对边排序
    public void edgeSortByWeight(Edge[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length-i-1; j++) {
                Edge temp = edges[j];
                if (edges[j].weight > edges[j+1].weight){
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

}
//边
class Edge{

    //初始顶点
    public char start;
    //结束顶点
    public char end;
    //权重
    public int weight;

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" + start +"," + end + ">" + "=" + weight;
    }
}
