package com.sh.study.exercise.every.six;

import java.util.*;

/**
 * 815. 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *
 * https://leetcode-cn.com/problems/bus-routes/solution/gong-jiao-lu-xian-by-leetcode-solution-yifz/
 *
 * @author zhouwenchen
 * @date 2021/6/28 19:39
 **/
public class NumBusesToDestination {

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<Integer,List<Integer>>();
        for (int i = 0;i < n; i++){
            for (int site: routes[i]){
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for (int j: list){
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site,list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis,-1);

        Queue<Integer> queue = new PriorityQueue<>();
        for (int bus: rec.getOrDefault(source,new ArrayList<>())){
            dis[bus] = 1;
            queue.offer(bus);
        }
        while (!queue.isEmpty()){
            Integer x = queue.poll();
            for (int y = 0; y < n; y++){
                if(edge[x][y] && dis[y] == -1){
                    dis[y] = dis[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus: rec.getOrDefault(target,new ArrayList<Integer>())){
            if(dis[bus] != -1){
                ret = Math.min(ret,dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public static void main(String[] args) {
        int[][] routes = new int[][]{
                {7,12},
                {4,5,15},
                {6},
                {15,19},
                {9,12,13}
        };
        int source = 15;
        int target = 12;

//        int[][] routes = new int[][]{
//                {1,2,7},
//                {3,6,7}
//        };
//        int source = 1;
//        int target = 6;
        System.out.println(numBusesToDestination(routes, source, target));
    }
}
