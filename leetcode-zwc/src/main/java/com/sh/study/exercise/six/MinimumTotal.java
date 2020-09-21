package com.sh.study.exercise.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @Author zhouwenchen
 * @Date  2020-09-14
 **/
public class MinimumTotal {

    /**
     * 递归操作实现，时间复杂度比较高
     * @param triangle
     * @return
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }
    /**
     * 递归调用
     */
    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size()){
            return 0;
        }
        return Math.min(dfs(triangle,i+1,j),dfs(triangle,i+1,j+1)) + triangle.get(i).get(j);
    }

    /**
     * 第二种递归，但是使用备忘录的
     * @param triangle
     * @return
     */
    static Integer[][] memo;
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return  dfs2(triangle, 0, 0);
    }

    private static int dfs2(List<List<Integer>> triangle, int i, int j) {
        if(i == triangle.size()){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs2(triangle,i+1,j),dfs2(triangle,i+1,j+1)) + triangle.get(i).get(j);
    }

    /**
     * 第三种想法，使用动态规划实现
     * @param triangle
     * @return
     */
    public static int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1; i >=0;i--){
            for(int j = 0; j<=i;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 第四种解法，动态规划，使用一维数组数组实现思路
     * @param triangle
     * @return
     */
    public static int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        for (int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= i;j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 第二种解法
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n ; ++i){
            // 最左边的一列初始化
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; ++j){
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
            }

            // 最右边，也就是 i = j 的时候
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        // 找出其中的最小值
        int minTotal  = f[n -1][0];
        for(int i = 1; i < n; ++i){
            minTotal = Math.min(minTotal,f[n-1][i]);
        }
        return minTotal;
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle  = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(triangle));

//        System.out.println(minimumTotal1(triangle));
//        System.out.println(minimumTotal2(triangle));
//        System.out.println(minimumTotal3(triangle));
//        System.out.println(minimumTotal4(triangle));
    }
}