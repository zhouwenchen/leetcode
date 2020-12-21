package com.sh.study.exercise.every;

import java.util.Arrays;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * @author ：zhouwenchen
 * @date ： 2020/12/20 9:57
 */
public class RemoveDuplicateLetters {

    /**
     * 1：先计数统计
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length();i++){
            nums[s.charAt(i)-'a']++;
        }
        // 再次遍历字符串,需要使用单调栈实现操作
        char[] stack = new char[26];
        // 表示栈中此时有几个元素
        int top = 0;
        boolean[] used = new boolean[26];
        for (char c : s.toCharArray()){
            char tmp;
            if(!used[c-'a']){
                // 栈，如果当前的元素比栈顶的元素小的话，且栈顶元素后面还会出现，出栈操作
                while (top > 0 && (tmp = stack[top-1]) > c && nums[tmp-'a'] > 0){
                    top--;
                    used[tmp - 'a'] = false;
                }
                // 如果当前的元素没有被使用的话，直接入栈操作
                stack[top++] = c;
                used[c-'a'] = true;
            }
            nums[c-'a']--;
        }

        return String.valueOf(Arrays.copyOf(stack, top));
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));    // abc
        System.out.println(removeDuplicateLetters("cbacdcbc")); // acdb
    }
}
