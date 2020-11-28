package com.sh.study.strmatch;

import java.util.Arrays;

/**
 * BF 算法实现
 *
 * @Author zhouwenchen
 * @Data 2020/8/19/16
 **/
public class BFalgorithm {
    /**
     * @param s   主串
     * @param t   模式串
     * @param pos 表示从主串什么位置开始计算
     * @return 返回模式串匹配到主串的第一个第一个位置
     */
    public static int bfFind(String s, String t, int pos) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int i = pos;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr1[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == arr2.length) {
            return i - j;
        }
        return -1;
    }

    /**
     * 202011271044
     *
     * @param s
     * @param t
     * @param pos
     * @return
     */
    private static final int SIZE = 256;
    private static void generateBC(char[] b,int m,int[] bc){
        // 初始化bc 数组为 -1
        Arrays.fill(bc,-1);
        // 计算 b[i] 的 ASCII 值
        for (int i = 0;i < m; i++){
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }
    // b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
    private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m-1-k]) { // 与 b[0, m-1] 求公共后缀子串
                --j;
                ++k;
                suffix[k] = j+1; //j+1 表示公共后缀子串在 b[0, i] 中的起始下标
            }

            if (j == -1) prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
        }
    }
    // j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] +1;
        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }

    /**
     * // a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    public static int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        // 构建坏的hash 表
        generateBC(b,m,bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        // j 表示主串与模式串匹配的第一个字符
        int i = 0;
        while (i <= n -m){
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是 j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if (j < m-1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "aaabbaaaccssdd";
        String b = "acc";
        int loc = bfFind(a, b, 3);
        System.out.println(loc);
    }
}
