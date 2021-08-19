package com.sh.study.exercise.every.eight;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 * @author zhouwenchen
 * @date 2021/8/5 20:32
 **/
public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {

        return 0;
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        };
        int n = 4,k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}
