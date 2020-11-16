package com.sh.study.exercise.every;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/15 9:31
 */
public class RemoveKdigits {
    /**
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        // 栈顶元素出栈操作
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean lendingZero = true;
        while (!deque.isEmpty()){
            Character digit = deque.pollFirst();
            // 如果首个是字符 '0' 的情况下，就不需要，
            if(lendingZero && digit == '0'){
                continue;
            }
            // 如果不是第一个的话，就不需要
            lendingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ?"0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
}
