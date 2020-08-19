package com.sh.study.graph;

import java.util.LinkedList;
import java.util.Queue;

//import static jdk.nashorn.internal.objects.Global.print;

/**
 * 图
 *
 * @Author zhouwenchen
 * @Data 2020/8/19/14
 **/
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 图的广度优先搜索
     * 搜索一条从 s 到 t 的路径
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 初始化 visited  和 queue
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        // 数组的初始化操作
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    /**
     * 深度优先
     * @param s
     * @param t
     */
    private boolean found = false;
    public void dfs(int s,int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i = 0; i < v; ++i){
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found){
            return;
        }
        visited[w] = true;
        if(w==t){
            found=true;
            return;
        }
        for(int i = 0; i < adj[w].size();++i){
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }

    public static void main(String[] args) {

    }
}
