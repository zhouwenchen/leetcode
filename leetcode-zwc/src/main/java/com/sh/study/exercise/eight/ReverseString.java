package com.sh.study.exercise.eight;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @Author zhouwenchen
 * @Date  2020-09-29
 **/
public class ReverseString {
    /**
     * 这是反转字符串
     *
     * 使用两个指针实现
     * @param s
     */
    public static void reverseString(char[] s) {
        if(s==null){
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 541. 反转字符串 II
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     * 提示：
     *
     * 该字符串只包含小写英文字母。
     * 给定字符串的长度和 k 在 [1, 10000] 范围内。
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] arrs = s.toCharArray();
        // i + 2k 是因为每隔 一个 k 的 后 一个k 才反转
        for (int i = 0; i < s.length();i+=2 * k){
            swap(arrs,i,i+k);//翻转
        }
        return new String(arrs);
    }

    /**
     *
     * @param arrs
     * @param i
     * @param j
     */
    private static void swap(char[] arrs, int i, int j) {
        /**
         * 如果i+k已经到了str的length的话，我们只能翻转到达length之前的那一段（限制2），为什么“-1”，比如
         * 例子中k=2，第一个翻转是ab，j= math.min(7,2)-1.要reverse的是ab --> ba,坐标正好是0，1(2-1).因为长度为2，代表着两个char，
         * 而i=0已经占有了一个char，所以要减去1，这是为了和坐标匹配。
         */
        j = Math.min(arrs.length,j)-1;
        while (i < j){
            char temp = arrs[i];
            arrs[i] = arrs[j];
            arrs[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
//        char[] s = new char[]{'h','e','l','l','o'};
//        char[] s = new char[]{'H','a','n','n','a','h'};
//        reverseString(s);
//        System.out.println(s);

//        String result = reverseStr("abcdefg", 2);//  bacdfeg
//        String result = reverseStr("abcd", 4); // dcba
//        String result = reverseStr("abcdefg", 8); // gfedcba
        String result = reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 3); // gfedcba
        System.out.println(result);
    }
}
