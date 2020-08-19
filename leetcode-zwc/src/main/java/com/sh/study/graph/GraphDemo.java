package com.sh.study.graph;

import java.util.LinkedList;

/**
 * 图的深度优先遍历和广度优先遍历
 * <p>
 * 原博客地址是：
 * https://www.jianshu.com/p/23b55db1adc0
 */
public class GraphDemo {

    private int vertexSize; // 顶点数量
    private int[] vertexs; // 顶点数组
    private int[][] matrix; // 包含所有顶点的数组
    // 路径权重
    // 0意味着顶点自己到自己，无意义
    // MAX_WEIGHT也意味着到目的顶点不可达
    private static final int MAX_WEIGHT = 1000;
    private boolean[] isVisited; // 某顶点是否被访问过

    public GraphDemo(int vertextSize) {
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for (int i = 0; i < vertextSize; i++) {
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }

    /**
     * 获取指定顶点的第一个邻接点
     *
     * @param index 指定邻接点
     * @return
     */
    private int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexSize; i++) {
            if (matrix[index][i] < MAX_WEIGHT && matrix[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取指定顶点的下一个邻接点
     *
     * @param v     指定的顶点
     * @param index 从哪个邻接点开始
     * @return
     */
    private int getNextNeighbor(int v, int index) {
        for (int i = index + 1; i < vertexSize; i++) {
            if (matrix[v][i] < MAX_WEIGHT && matrix[v][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 图的深度优先遍历算法
     */
    private void depthFirstSearch(int i) {
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                // 需要遍历该顶点
                System.out.println("访问到了：" + w + "顶点");
                // 进行深度遍历
                depthFirstSearch(w);
            }
            // 第一个相对于w的邻接点
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 图的广度优先遍历算法
     */
    private void boardFirstSearch(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println("访问到了：" + i + "顶点");
        isVisited[i] = true;
        queue.add(i);

        while (queue.size() > 0) {
            int w = queue.removeFirst().intValue();
            int n = getFirstNeighbor(w);
            while (n != -1) {
                if (!isVisited[n]) {
                    System.out.println("访问到了：" + n + "顶点");
                    isVisited[n] = true;
                    queue.add(n);
                }
                n = getNextNeighbor(w, n);
            }
        }
    }

    public static void main(String[] args) {
        GraphDemo graph = new GraphDemo(9);

        // 顶点的矩阵设置
        int[] a1 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, 24, 16, 21};
        //int[] a4 = new int[] { MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21 };
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] a6 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] a7 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, 24, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        //int[] a7 = new int[] { MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
        int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] a9 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;
        graph.matrix[5] = a6;
        graph.matrix[6] = a7;
        graph.matrix[7] = a8;
        graph.matrix[8] = a9;

        graph.depthFirstSearch(0);
//        graph.boardFirstSearch(0);
    }
}