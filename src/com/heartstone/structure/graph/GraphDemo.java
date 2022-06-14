package com.heartstone.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 图
 *
 * @author
 * @date 2022-06-14 10:58
 */
public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        String[] vertexArr = new String[]{"1", "2", "3", "4", "5","6","7","8"};
        for (String s : vertexArr) {
            graph.addVertex(s);
        }
//        graph.addEdge(0, 1, 1);//A->B
//        graph.addEdge(0, 2, 1);
//        graph.addEdge(1, 2, 1);
//        graph.addEdge(1, 3, 1);
//        graph.addEdge(1, 4, 1);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.addEdge(3,7,1);
        graph.addEdge(4,7,1);
        graph.addEdge(2,5,1);
        graph.addEdge(2,6,1);
        graph.addEdge(5,6,1);

        graph.listEdges();
        System.out.println("深度优先");
        graph.dfsList();
        System.out.println("广度优先");
        graph.bfs();

    }

}

class Graph {

    //顶点集合
    List<String> vertexList;

    //图的邻接矩阵
    int[][] edges;

    //边的条数
    int numOfEdges;

    /**
     * 图的构造方法
     *
     * @param n 顶点数
     */
    public Graph(int n) {
        vertexList = new ArrayList<>();
        edges = new int[n][n];
        numOfEdges = 0;
    }

    //深度优先遍历
    public void dfsList() {
        boolean[] isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfsList(isVisited, i);
            }
        }
    }

    public void bfs(){
        boolean[] isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfsList(isVisited, i);
            }
        }
    }

    /**
     * 广度优先搜索
     *
     * @param isVisited 是否已经访问
     * @param i         初始节点
     */
    private void bfsList(boolean[] isVisited, int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(vertexList.get(i) + "=>");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列中第一个节点
            int u = queue.removeFirst();
            //当前节点的下一个节点
            int w = getNeighborIndex(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(vertexList.get(w) + "=>");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighborIndex(u, w);
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param i 初始顶点的下标
     */
    private void dfsList(boolean[] isVisited, int i) {
        System.out.printf("%s->", vertexList.get(i));
        isVisited[i] = true;
        int w = getNeighborIndex(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfsList(isVisited, w);
            }
            w = getNextNeighborIndex(i, w);
        }
    }

    public int getNeighborIndex(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighborIndex(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 添加顶点
     *
     * @param vertex 待添加顶点
     */
    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加无相图的边
     *
     * @param v1     顶点v1的下标
     * @param v2     顶点v2的下标
     * @param weight 顶点v1和v2的权重
     */
    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 获取边数
     *
     * @return 边数
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 获取顶点数
     *
     * @return 顶点数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回下标对应的顶点
     *
     * @param index 下标
     * @return 顶点
     */
    public String getVertexByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 展示邻接矩阵
     */
    public void listEdges() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
