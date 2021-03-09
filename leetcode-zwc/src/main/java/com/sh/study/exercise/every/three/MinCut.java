package com.sh.study.exercise.every.three;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 */
public class MinCut {
    /**
     *
     * @param s
     * @return
     */
    public static int minCut(String s) {
        int m = s.length();
        boolean[][] used = new boolean[m][m];
        for (int i = 0; i < m; i++){
            Arrays.fill(used[i],true);
        }

        for (int i = m - 1; i >= 0; --i){
            for (int j = i+1; j < m;++j){
                used[i][j] = s.charAt(i) == s.charAt(j) && used[i+1][j-1];
            }
        }

        int[] f = new int[m];
        Arrays.fill(f,Integer.MAX_VALUE);
        for (int i = 0; i < m ;i++){
            if(used[0][i]){
                f[i] = 0;
            } else {
                for (int j = 0; j < i;++j){
                    if(used[j+1][i]){
                        f[i] = Math.min(f[i],f[j]+1);
                    }
                }
            }
        }
        return f[m-1];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
