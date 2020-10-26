package com.sh.study.exercise.nine;

import java.util.Enumeration;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * @Author zhouwenchen
 * @Data 2020/10/26/11
 **/
public class MaxAreaOfIsland {

    private static int n;
    private static int m;

    /**
     * 当遇到当前是 1 的时候，需要判断相邻的是否是 1
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        if(n == 0){
            return 0;
        }
        m = grid[0].length;
        int maxAreaOfIsland = 0;
        for (int i = 0; i < n;i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    maxAreaOfIsland = Math.max(maxAreaOfIsland, dfs(grid,i, j));
                }
            }
        }
        return maxAreaOfIsland;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >=n || j >=m || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid, i+1, j);
        num += dfs(grid, i-1, j);
        num += dfs(grid, i, j+1);
        num += dfs(grid, i, j-1);
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
