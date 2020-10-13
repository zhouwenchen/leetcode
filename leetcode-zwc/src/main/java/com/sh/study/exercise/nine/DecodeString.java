package com.sh.study.exercise.nine;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @Author zhouwenchen
 * @Date  2020-10-13
 **/
public class DecodeString {
    /**
     * 使用两个栈实现操作 3[a2[c]]
     * 从左向右遍历字符串
     *
     * stack1 存储 3，遇到 ‘[’ 时，存储到stack2， '[a'
     * 遇到 2存储在statk1  ‘32’，遇到 ‘[’,存储stack2 ，'[a[c'
     * 当第一次遇到 ‘]’ 的时候，从stack2 中取出字符，直到取到第一次出现'['为止，也就是取出了 ‘c’,重复次数，取出了 2。 也就是组成了 'cc',存入到stack2中 ，此时statck1 ‘3’，stack2 ‘[acc’ ,
     * 继续从 stack2中取出字符，直到取到第一次出现‘[’ 为止，也就是取出了 ‘acc’，从stack1中取出了重复次数 3.也就是组成了 accaccacc
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        char[] arr = s.toCharArray();
        // 遍历 arr
        Deque<String> deque = null;
        String temp = null;
        String result = "";
        // 正则匹配到数值类型
        String num = "";
        for (int i = 0; i < arr.length;i++) {
            char c = arr[i];
            // 存储在stack1
            if('0'<= c && '9'>=c){
                num += String.valueOf(c);
//                stack1.push(Integer.parseInt(String.valueOf(c)));
                continue;
            }
            // 如果 num 转换成 Integer 大于0 且当前  c 不是数值 ，将 num 存入到 stack1 中
            if(num != "" && Integer.parseInt(num) >= 1 && ('a' <= c && 'z' >= c || '[' == c ||  ('A' <= c && 'Z' >= c )) ){
                stack1.push(Integer.parseInt(num));
                num = "";
            }
            // 存储在stack2 中
            if('[' == c  || !stack2.isEmpty() &&( ('a' <= c && 'z' >= c ) || ('A' <= c && 'Z' >= c ))) {
                stack2.push(String.valueOf(c));
            }
            // 从 stack2中弹出字符，并
            if(']' == c){
                deque = new ArrayDeque<>();
                StringBuffer sb = new StringBuffer();
                while (!stack2.isEmpty() && !stack2.peek().equals(String.valueOf('['))){
                    deque.addFirst(stack2.pop());
                }
                // 弹出 '['
//                if(!stack2.isEmpty() && stack2.peek().equals('[')){
                    stack2.pop();
//                }
                // TODO 仅符合一位数
                Integer count = stack1.pop();
                while (!deque.isEmpty()){
                    sb.append(deque.removeFirst());
                }
                temp = String.join("", Collections.nCopies(count, sb.toString()));

//                while (!stack2.isEmpty() && stack2.peek().equals(String.valueOf('['))){
//                    temp = stack2.pop() + sb.toString();
//                }
                // 如果 stack1 不为空的话，继续存入到 stack2 中
                if(!stack2.isEmpty()){
                    stack2.push(temp);
                }else{
                    result += temp;
                }
            }
            // 添加不需要重复的
            if(stack2.isEmpty() && 'a' <= c && 'z' >= c){
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println(decodeString("2[abc]xxx3[cd]ef")); // abcabccdcdcdef
        System.out.println(decodeString("100[leetcode]")); // abcabccdcdcdef
        System.out.println(decodeString("3[a]2[b4[F]c]")); // abcabccdcdcdef
//        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); // abcabccdcdcdef
        System.out.println(decodeString("2[2[f]]")); // abcabccdcdcdef
    }

}
