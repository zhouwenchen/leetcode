package com.sh.study.exercise.nine;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 *
 * @Author zhouwenchen
 * @Data 2020/10/26/10
 **/
public class Solve {
    private static int n;
    private static int m;
    public static void solve(char[][] board) {
        n = board.length;
        if(n == 0){
            return;
        }
        m = board[0].length;

        // 遍历获取数据
        for (int i = 0; i < n; i++){
            dfs(board,i,0);
            dfs(board, i,m-1);
        }

        for (int i = 1; i < m-1;i++){
            dfs(board,0,i);
            dfs(board,n-1,i);
        }

        // 遍历，将字符 'A' 转换成  'O'
        for (int i = 0; i < n;i++){
            for (int j = 0; j < m;j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * @param board
     * @param x
     * @param y
     */
    private static void dfs(char[][] board, int x, int y) {
        if(x < 0 || x>= n|| y < 0|| y>=m || board[x][y]!= 'O'){
            return;
        }
        // 替换成一个字符
        board[x][y] = 'A';
        dfs(board, x+1, y);
        dfs(board, x-1, y);
        dfs(board, x, y+1);
        dfs(board, x, y-1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        Arrays.stream(board).forEach(System.out::println);
    }
}
