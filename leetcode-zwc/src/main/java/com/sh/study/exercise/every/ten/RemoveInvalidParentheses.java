package com.sh.study.exercise.every.ten;

import java.util.List;

/**
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 * 示例 1：
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 *
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 *
 * 输入：s = ")("
 * 输出：[""]
 *
 * @author zhouwenchen
 * @date 2021/10/27 9:50
 **/
public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        return null;
    }

    public static void main(String[] args) {
        removeInvalidParentheses("()())()").stream().forEach(System.out::println);
    }
}
