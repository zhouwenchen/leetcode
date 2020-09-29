package com.sh.study.exercise.eight;

import java.util.Arrays;
import java.util.Collections;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * @Author zhouwenchen
 * @Date  2020-09-29
 **/
public class ReverseWords {
    /**
     * 使用工具类  Collections.reverse
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        // 去除空格
        if("".equals(s.trim())){
            return "";
        }
        String[] arrs = s.split(" ");
        Collections.reverse(Arrays.asList(arrs));
        StringBuffer sb = new StringBuffer();
        for (String arr:arrs){
            if("".equals(arr)){
                continue;
            }
            sb.append(arr).append(" ");
        }
        return sb.toString().substring(0, sb.lastIndexOf(" "));
    }

    /**
     * 使用其他的方式实现
     *
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        // 去除空格
        if("".equals(s.trim())){
            return "";
        }
        String[] arrs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = arrs.length - 1; i >= 0; i--){
            if("".equals(arrs[i])){
                continue;
            }
            sb.append(arrs[i]).append(" ");
        }
        return sb.toString().substring(0, sb.lastIndexOf(" "));
    }

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 示例：
     *
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * @param s
     * @return
     */
    public static String reverseWords3(String s) {
        if(s==null || s.length() ==0){
            return s;
        }
        String[] nums = s.split(" ");

        StringBuffer sb = new StringBuffer();
        for(String num: nums){
            int start = 0;
            int end = num.length() - 1;
            char[] arrs = num.toCharArray();
            while ( start < end){
                char temp = arrs[start];
                arrs[start] = arrs[end];
                arrs[end] = temp;
                start++;
                end--;
            }
            sb.append(arrs).append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
//        String s = "the sky is blue"; // blue is sky the
//        String s = "a good   example"; // blue is sky the
//        String s = " "; // blue is sky the
        String s = "Let's take LeetCode contest";       // s'teL ekat edoCteeL tsetnoc
        System.out.println(reverseWords3(s));
    }
}