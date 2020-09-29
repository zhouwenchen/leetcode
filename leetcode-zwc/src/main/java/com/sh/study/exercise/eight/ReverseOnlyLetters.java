package com.sh.study.exercise.eight;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 *
 * @Author zhouwenchen
 * @Date  2020-09-29
 **/
public class ReverseOnlyLetters {
    /**
     * 如何判断字符在  [a-z && A-Z] 之间，如何判断
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        if(S== null || S.length() == 0){
            return S;
        }

        char[] arrs = S.toCharArray();
        int start = 0;
        int end = arrs.length - 1;
        for (char arr : arrs){
            // 判断字符是否满足条件，通过双指针实现替换操作
            if(arr >= 'a' && arr <= 'z' || arr >='A' && arr <= 'Z'){
                while (start < end){
                    char temp = arrs[start];
                    arrs[start] = arrs[end];
                    arrs[end] = temp;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }
}
