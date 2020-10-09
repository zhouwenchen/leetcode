package com.sh.study.exercise.six;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @Author zhouwenchen
 * @Date  2020-09-17
 **/
public class LongestValidParentheses {

    /**
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        char left = '(';
//        char right = ')';

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == left){
                stack.push(i);
            } else {
                stack.poll();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i -stack.peek());
                }
            }
        }
        return max;
    }
    /**
     * 使用动态规划实现操作
     * 状态转移方程式：
     *  第i个字符是左括号"("，那么以他结尾的是构不成有效括号的，所以dp[i]==0;
     *  第i个字符是右括号")"，那么以他结尾的是有可能构成有效括号的，所以还需要判断
     *  类似于这种……()，我们需要判断第i-1个字符是不是"("，如果是的话，那么最长有效括号就是第i-2个字符之前构成的最长有效括号+2，也就是dp[i]=dp[i-2]+2。
     *  类似于这种……((……))，我们看一下下面的图来看下，所以我们要判断第i -1- dp[i - 1]个字符是否是"(",如果是，
     *      那么递推公式是dp[i]=dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2],这里dp[i - dp[i - 1] - 2]是第一个省略号构成的有效括号，这个不要忘了
     *
     * @param s
     */
    public static int longestValidParentheses1(String s) {
        int max = 0;
        s = " " + s;
        int[] dp = new int[s.length()];
        for(int i = 2; i < s.length() ; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = dp[i-1] + 2;
                }else if(s.charAt(i - dp[i - 1 ] - 1) == '('){
                    dp[i] = dp[i-1] + 2 + dp[i-dp[i-1] -2 ];
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = ")()())"; // 4
        String s2 = "(()";  // 2
        String s3 = "((()))"; //6
        String s4 = "(";    // 0
        String s5 = ")(";     //0
        String s6 = "()(())"; // 6
        String s7 = "()(()"; // 2

        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
        System.out.println(longestValidParentheses(s3));
        System.out.println(longestValidParentheses(s4));
        System.out.println(longestValidParentheses(s5));
        System.out.println(longestValidParentheses(s6));
        System.out.println(longestValidParentheses(s7));
    }
}
