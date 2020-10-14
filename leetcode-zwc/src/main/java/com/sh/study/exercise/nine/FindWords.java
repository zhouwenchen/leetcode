package com.sh.study.exercise.nine;


import com.sh.study.node.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 *
 * @Author zhouwenchen
 * @Date  2020-10-14
 **/
public class FindWords {
    private static Trie trie;
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int m;
    private static int n;

    /**
     * dfs 和 回溯 方法
     * @param board
     * @param words
     * @return
     */
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if(board==null){
            return ans;
        }
        TrieNode root = new TrieNode();
        trie = new Trie();
        for (String word: words){
            trie.insert(word);
        }
        m = board.length;
        n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m;i++){
            for (int j = 0; j < n;j++){
                StringBuilder sb = new StringBuilder();
                findHelper(i,j,marked,sb,ans,board);
            }
        }
        return ans;
    }

    private static void findHelper(int i, int j, boolean[][] marked, StringBuilder sb, List<String> ans, char[][] board) {
        sb.append(board[i][j]);
        //该位置在本次启动的递归中已经访问过或者前缀树中没有这个前缀，回溯
        if(marked[i][j] || !trie.startsWith(sb.toString())){
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        marked[i][j] = true;
        // 找到了单词
        String str = sb.toString();
        if(trie.search(str)){
            // 去重
            if(!ans.contains(sb.toString())){
                ans.add(str);
            }
            // 判断当前单词是否还作为前缀出现
            if(!trie.startsWith(str)){
                sb.deleteCharAt(sb.length()-1);
                marked[i][j] = false;
                return;
            }
        }

        for (int k = 0; k < 4; k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY)) {
                findHelper(newX, newY, marked, sb, ans,board);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        marked[i][j] = false;
    }

    private static boolean inArea(int x,int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        // "eat","oath"
        findWords(board,words).forEach(System.out::println);
    }
}