package com.sh.study.exercise.seven;

import java.util.*;

/**
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

    public static void main(String[] args) {
        solveNQueens(8).stream().forEach(o->Arrays.asList(o).stream().forEach(System.out::println));
    }
}
