package com.sh.study.exercise.nine;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * @Author zhouwenchen
 * @Date  2020-10-14
 **/
public class FindTheDifference {
    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        String temp = s+t;
        char[] arr = temp.toCharArray();
        char result = ' ';
        for(char c: arr){
            result ^= c;
        }
        return (char)((char)result + 32);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("a", "aa"));
        System.out.println(findTheDifference("ae", "aea"));
        System.out.println(findTheDifference("", "y"));
//        System.out.println('a'^'b');

//        System.out.println(((char)('a'^'b'^'c'^'a'^'b'^'c'^'a')));
        System.out.println((('a'^'a')));

    }
}
