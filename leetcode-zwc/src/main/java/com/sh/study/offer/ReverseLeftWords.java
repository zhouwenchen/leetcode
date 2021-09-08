package com.sh.study.offer;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/8 11:13
 **/
public class ReverseLeftWords {

    public static String reverseLeftWords(String s, int n) {
        String firstStr = s.substring(0, n);
        String digster = s.substring(n);
        return digster+=firstStr;
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }
}
