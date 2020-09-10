package com.sh.study.exercise.four;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * @Author zhouwenchen
 * @Data 2020/9/10/18
 **/
public class NumIslands {

    /**
     * 使用递归标注的方式实现的逻辑，将相邻的1标注为2，岛屿数量加1操作
     * 先遍历这个二维数组，则岛屿数量加1，然后将该岛屿附近的所有的数据都置为2,
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int islandNum = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    infect(grid, i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    /**
     * 岛屿数量加1操作
     * @param grid
     * @param i
     * @param j
     */
    private static void infect(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[0].length|| grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i+1, j);
        infect(grid, i-1, j);
        infect(grid, i, j+1);
        infect(grid, i, j-1);
    }

    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};

        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int count = numIslands(grid);

        System.out.println(count);
    }
}
