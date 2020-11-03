package com.sh.study.exercise.seven;

import java.util.*;

/**
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @Author zhouwenchen
 * @Date  2020-09-27
 **/
public class SolveNQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queues = new int[n];
        // 队列中填充所有的数据为  -1
        Arrays.fill(queues,-1);

        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();

        backtrack(result,queues,n,0,columns,diagonals1,diagonals2);
        return result;
    }

    private static void backtrack(List<List<String>> result, int[] queues, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 结束的条件
        if(row == n){
            List<String> board = generateBoard(queues,n);
            result.add(board);
            return;
        } else {
            for(int i = 0; i < n; i++){
                if(columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }

                queues[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(result,queues,n,row+1,columns,diagonals1,diagonals2);
                queues[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    /**
     * 生成
     * @param queues
     * @param n
     * @return
     */
    private static List<String> generateBoard(int[] queues, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /**
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens1(int n) {
        char[][] chess = new char[n][n];
        // 初始化数组
        for (int i = 0; i < n;i++){
            for (int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private static void solve(List<List<String>> res, char[][] chess, int row) {
        // 终止条件，最后一行都走完了的话，说明找到了一组，把他加入到集合中 res
        if(row == chess.length){
            res.add(construct(chess));
            return;
        }

        // 遍历每一行
        for (int col = 0; col < chess.length;col++){
            // 判断当前位置是否可以防止皇后
            if(vaild(chess,row,col)){
                // 复制数组
                char[][] temp = copy(chess);
                // 在当前位置放置皇后
                temp[row][col] = 'Q';
                // 递归到下一行继续
                solve(res,temp,row + 1);
            }
        }
    }

    //把二维数组chess中的数据测下copy一份
    private static char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }

    /**
     * 验证当前的位置是否放置皇后
     * @param chess
     * @param row
     * @param col
     * @return
     */
    private static boolean vaild(char[][] chess, int row, int col) {
        // 当前位置的上面有没有
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // 当前坐标的右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    /**
     * 创建数组
     * @param chess
     * @return
     */
    private static List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length;i++){
            path.add(new String(chess[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        solveNQueens1(8).stream().forEach(o->Arrays.asList(o).stream().forEach(System.out::println));
    }
}
