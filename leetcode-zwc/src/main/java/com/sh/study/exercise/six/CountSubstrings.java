package com.sh.study.exercise.six;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * @Author zhouwenchen
 * @Date  2020-09-17
 **/
public class CountSubstrings {

    /**
     * 暴力解法
     * 时间复杂度是 O(n^3)
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length();j++){
                if(isPalindrome(s.substring(i,j+1))){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 使用双向指针来判断
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String[] arr = s.split("");
        while (i < j){
            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 动态规划的实现思路
     *  状态转移方程式：[i,j],表示在区间中[i,j] 中是否有回文子串
     *  形如 s = ababa,    s1 = bab 是  s 的子串，   那么在  s1 的基础上  两边各加一个 a,也就是  s 是否是一个子串
     *  如果 s[i] == s[j],那么 dp[i][j] = dp[i+1][j-1]是不是一个回文子串
     *
     *  TODO 这个条件（j-i < 2 ）没怎么弄明白
     * @param s
     */
    public static int countSubstrings2(String s){
        if( s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        for(int j = 0; j < len; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
//        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings2(s));
    }
}
