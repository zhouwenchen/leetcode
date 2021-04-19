package com.sh.study.exercise.every.four;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 * 示例 2：
 * <p>
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 * 通过次数21,966提交次数45,169
 * 请问您在哪类招聘中遇到此题？
 * 贡献者
 * LeetCode
 *
 * @author zhouwenchen
 * @date 2021/4/16 11:24
 **/
public class IsScramble {

    /**
     * 递归超时
     *
     * @param s1
     * @param s2
     * @returnshifou
     */
    public static boolean isScramble(String s1, String s2) {
        int len = s1.length();
        // 长度不同，必定不同
        if (s1.length() != s2.length()) {
            return false;
        }
        // 如果长度相等，判断一下特例
        if (s1.equals(s2)) {
            return true;
        }
        // 判断两个字符串中每个字符出现的次数是否相等，如果不相等的话，直接返回false
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) - 1);
        }
        // 判断每个元素是否为空
        Set<Character> set = map.keySet();
        for (Character key : set) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        // 如果相同的话，开始判断
        for (int i = 1; i < len; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                            // S1 -> T2，S2 -> T1
                            (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 没有搞明白
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble1(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        boolean[][][] f = new boolean[n][n][n + 1];

        // 先处理长度为 1 的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = cs1[i] == cs2[j];
            }
        }

        // 再处理其余长度情况
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        boolean a = f[i][j][k] && f[i + k][j + k][len - k];
                        boolean b = f[i][j + len - k][k] && f[i + k][j][len - k];
                        if (a || b) {
                            f[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }

    public static void main(String[] args) {
        String s1 = "eebaacbcbcadaaedceaaacadccd";
        String s2 = "eebaacbcbcadaaedceaaacadccd";
        System.out.println(isScramble1("great", "rgeat"));
        System.out.println(isScramble(s1,s2));
        System.out.println(isScramble1(s1,s2));
    }
}
