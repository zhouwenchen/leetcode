package com.sh.study.exercise.every.two;

import java.util.*;

/**
 * 1763. 最长的美好子字符串
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 *
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "YazaAay"
 * 输出："aAa"
 * 解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
 * "aAa" 是最长的美好子字符串。
 * 示例 2：
 *
 * 输入：s = "Bb"
 * 输出："Bb"
 * 解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。
 * 示例 3：
 *
 * 输入：s = "c"
 * 输出：""
 * 解释：没有美好子字符串。
 * 示例 4：
 *
 * 输入：s = "dDzeE"
 * 输出："dD"
 * 解释："dD" 和 "eE" 都是最长美好子字符串。
 * 由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含大写和小写英文字母。
 *
 * @author zhouwenchen
 * @date 2022/2/16 9:54
 **/
public class LongestNiceSubstring {

    /**
     * s 转化成字符数组
     * 小写字母和大写字母相差为32
     * 相同类型，相减绝对值为0，不同类型相减绝对值为32
     * TODO 我以下的解法，只满足必须要连续，如果不连续就不可以
     * @param s
     * @return
     */
    public static String longestNiceSubstring(String s) {
        char[] arr = s.toCharArray();
        if(arr.length <=1){
            return "";
        }

        Deque<Character> stack = new ArrayDeque<>();
        boolean flag = false;
        String maxValue = null;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(stack.isEmpty()){
                stack.push(c);
            }else {
                Character topValue = stack.peek();
                if(topValue.equals(c) || Math.abs(topValue - c) == 32 ){
                    stack.push(c);
                    flag = false;
                }else {
                    // 可能下一次才会存在，此时需要将其放入到栈中，
                    if(flag || stack.size() == 1){ // 但是此时falg 为 true，说明上一次放入进去，但是不是和前一个匹配的

                        stack.pop();
                        // 说明此时已经不连续了，就取出，而且记录大小
                        StringBuilder sb = new StringBuilder();
                        while (!stack.isEmpty()){
                            sb.append(stack.pollLast());
                            if(stack.isEmpty()){
                                // 判断此时sb 的长度和 result中已经存在的长度是否比较长
                                maxValue = maxValue == null? sb.toString():maxValue.length()>= sb.length()?maxValue:sb.toString();
                            }
                        }
                    }
                    if(i < arr.length -1){ // 此时已经没有元素了，这个直接跳过
                        stack.push(c);
                        flag = true;
                    }
                }
            }
        }
        //
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
            if(stack.isEmpty()){
               maxValue = maxValue == null ? sb.toString() : maxValue.length() >= sb.length()?maxValue:sb.toString();
            }
        }

        return maxValue == null?"":maxValue;
    }

    /**
     *
     * @param s
     * @return
     */
    public static String longestNiceSubstring1(String s) {
        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; j++) {
                if(Character.isLowerCase(s.charAt(j))){
                    lower |= 1 << (s.charAt(j) - 'a');
                }else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                if(lower == upper && j - i + 1 > maxLen){
                    maxPos = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxPos,maxPos + maxLen);
    }


    public static void main(String[] args) {
//        System.out.println(longestNiceSubstring("AaBbCc"));         //Aa
//        System.out.println(longestNiceSubstring("YazaAayBbBb"));    // BbBb
//        System.out.println(longestNiceSubstring("YazaAaBbBb"));     // aAaBbBb
//        System.out.println(longestNiceSubstring("YazaAay"));     // aAa
//        System.out.println(longestNiceSubstring("aAay"));     // aAa
//        System.out.println(longestNiceSubstring("dDzeE"));     // dD
        System.out.println(longestNiceSubstring("jcJ"));     // ""
        System.out.println(longestNiceSubstring1("BebjJE"));     // "BebjJE" TODO 未实现操作


    }
}
