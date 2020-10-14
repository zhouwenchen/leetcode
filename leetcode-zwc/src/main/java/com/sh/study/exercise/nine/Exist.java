package com.sh.study.exercise.nine;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @Author zhouwenchen
 * @Date  2020-10-14
 **/
public class Exist {

    /**
     * 使用 dfs 和 回溯的方法实现操作
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char[] target = word.toCharArray();
        int index = 0;
        for(int i = 0; i < board.length;i++){
            for (int j = 0; j < board[0].length;j++){
                char cur = board[i][j];
                if(cur == target[index]){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int k) {
        // 退出条件
        if(k == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(word.charAt(k) != board[i][j]){
            return false;
        }

        // 准备回溯操作
        char t = board[i][j];
        board[i][j] = '0';

        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1) || dfs(board,word,i-1,j,k+1);
        // 回溯完成
        board[i][j] = t;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCCED"));
    }
}
