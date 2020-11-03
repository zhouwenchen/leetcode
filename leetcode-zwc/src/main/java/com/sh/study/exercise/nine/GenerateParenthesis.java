package com.sh.study.exercise.nine;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * @Author zhouwenchen
 * @Data 2020/10/26/16
 **/
public class GenerateParenthesis {

    /**
     * 使用回溯的方式实现操作
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrance(ans,new StringBuilder(),0,0,n);
        return ans;
    }


    private static void backtrance(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // 结束条件
        if(cur.length() == 2 * max){
            ans.add(cur.toString());
            return;
        }
        if(open < max){
            cur.append("(");
            backtrance(ans,cur,open + 1,close,max);
            cur.deleteCharAt(cur.length() -1);
        }
        if(close < open){
            cur.append(")");
            backtrance(ans,cur,open,close + 1,max);
            cur.deleteCharAt(cur.length() -1);
        }
    }

    /**
     * 使用动态规划操作实现
     * TODO 搞不懂啥
     *
     */
    public static List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            result.add("");
            return result;
        }
        for (int i = 0; i < n; i++) {
            int k = n - i - 1;
            List<String> first = generateParenthesis1(i);
            List<String> second = generateParenthesis1(k);
            for (String left : first) {
                for (String right : second) {
                    result.add("(" + left + ")" + right);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        generateParenthesis1(3).stream().forEach(System.out::println);
    }
}
