package com.sh.study.strmatch;

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

    public static void main(String[] args) {
        String a = "aaabbaaaccssdd";
        String b = "acc";
        int loc = bfFind(a, b, 3);
        System.out.println(loc);
    }
}
