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
     * 前后指针，start end。start 从前找到第一个字符，end从后遍历，找到第一个字符，交换 start 和 end 位置的数据
     *
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        if(S== null || S.length() == 0){
            return S;
        }

        char[] arrs = S.toCharArray();
        for (int start = 0, end = arrs.length -1; start < end; ){
            while ((start < end ) &&(arrs[start] < 'a' || arrs[start] > 'z' )&& (arrs[start] < 'A' || arrs[start] > 'Z')){
                start++;
            }
            while ((start < end ) && (arrs[end] < 'a' || arrs[end] > 'z' )&& (arrs[end] < 'A' || arrs[end] > 'Z')){
                end--;
            }
            // 替换
            if (start < end){
                char temp = arrs[start];
                arrs[start] = arrs[end];
                arrs[end] = temp;
            }
            start++;
            end--;
        }
        return new String(arrs);
    }

    public static void main(String[] args) {
//        String s = "a-bC-dEf-ghIj"; // "j-Ih-gfE-dCba"
//        String s = "Test1ng-Leet=code-Q!"; // "Qedo1ct-eeLg=ntse-T!"
        String s = "7_28]"; // "Qedo1ct-eeLg=ntse-T!"
        System.out.println(reverseOnlyLetters(s));
    }
}
