package com.sh.study.exercise.eight;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @Author zhouwenchen
 * @Date 2020-09-30
 **/
public class ValidPalindrome {

    /**
     * 第二种解法
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                // 分为两种情况，i++ 或者是 j--
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "aba";
//        String s = "abba";

//        String s = "abcea";
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }
}
