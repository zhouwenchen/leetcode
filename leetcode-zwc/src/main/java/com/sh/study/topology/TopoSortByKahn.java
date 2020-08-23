package com.sh.study.topology;

import java.util.LinkedList;

/**
 * 拓扑排序操作
 */
public class TopoSortByKahn {

    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public TopoSortByKahn(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // s 先于 t，边 s->t
        adj[s].add(t);
    }

    /**
     * Kahn 算法
     */
    public void topoSortByKahn(){
        // 统计每个顶点的入度操作
        int[] inDegree = new int[v];
        for(int i = 0; i < v; i++){
            for(int j = 0; j < adj[i].size();++j){
//                i->w
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < v;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int i = queue.remove();
            System.out.println("->" + i);
            for(int j = 0; j < adj[i].size();++j){
                int k = adj[i].get(j);
                inDegree[k]--;
                if(inDegree[i] == 0){
                    queue.add(k);
                }
            }
        }
    }

    /**
     */
    public void topoSortByDFS(){
        // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        // 申请空间
        for(int i = 0; i < v; i++){
            inverseAdj[i] = new LinkedList<>();
        }
        // 通过邻接表生成逆邻接表
        for(int i  = 0; i < v;i++){
            for(int j = 0; j < adj[i].size();++j){
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }

        boolean[] visited = new boolean[v];
        // 深度优先遍历
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,inverseAdj,visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for(int i = 0; i < inverseAdj[vertex].size();++i){
            int w = inverseAdj[vertex].get(i);
            if(visited[w]){
                continue;
            }
            visited[i] = true;
            dfs(w,inverseAdj,visited);
        }
        // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        TopoSortByKahn topoSortByKahn = new TopoSortByKahn(10);
//        topoSortByKahn.topoSortByKahn();

        topoSortByKahn.topoSortByDFS();
    }
}
