package com.sh.study.exercise.eight;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 *
 * @author zhouwenchen
 * @date 2021/8/24 11:28
 **/
public class ReverseStr {

    public static String reverseStr(String str, int k) {
        if(k==1){
            return str;
        }
        int left = 0,n = str.length();
        char[] s = str.toCharArray();
        while (left < n){ // l,r 分别指向当前反转部分的首尾字符
            int l = left,r = Math.min(n-1,left + k - 1);
            while (l < r)
                swap(s,l++,r--);
            left += (k<<1);
        }
        return new String(s);
    }

    private static void swap(char[] arr, int a, int b) {
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    /**
     *
     * @param str
     * @param k
     * @return
     */
    public static String reverseStr1(String str, int k) {
        if(k==1)return str;
        int l = 0,n = str.length();
        char[] arr = str.toCharArray();
        for (int i = 0; i < n;i+=2 * k){
            swap1(arr,i,i+k);
        }
       return new String(arr);
    }

    private static void swap1(char[] arr, int l, int r) {
        r = Math.min(arr.length,r) - 1;
        while (l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr1("abcdefg", 2));
    }
}
