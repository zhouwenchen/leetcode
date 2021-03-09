package com.sh.study.exercise.every.three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 */
public class Partition {

    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }

        Deque<String> stack = new ArrayDeque<>();
        char[] charArray  = s.toCharArray();
        dfs(charArray ,0,len,stack,res);
        return res;
    }

    /**
     *
     * @param charArray
     * @param index
     * @param len
     * @param path
     * @param res
     */
    private static void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if(len == index){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index;i < len;i++){
            if(!checkPalindrome(charArray,index,i)){
                continue;
            }
            path.add(new String(charArray,index,i+1-index));
            dfs(charArray,i+1,len,path,res);
            path.removeLast();
        }
    }

    /**
     *
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private static boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        partition("aab").stream().forEach(System.out::println);
    }
}
