package com.sh.study.exercise.every;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Arrays;
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

    /**
     *  TODO 未完成
     * @param nums
     * @param k
     * @return
     */
    private static String maxNumberK(String nums, int k) {
        int n = nums.length();
        int size = n - k;
        if(k == 0){
            return nums;
        }
        if(k == n){
            return "0";
        }

        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n;i++){
            // 如果堆栈非空，且当前元素 比 栈顶元素 大，移除 栈顶元素
            while (k >0 && top > 0 && nums.charAt(i) < stack[top-1]){
                top--;
                k--;
            }
            stack[top++] = nums.charAt(i);// 当前元素入栈
        }
        top -=k;
        // 如果k大于0，再移除k个栈顶元素
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size;i++){
            sb.append(stack[i]-'0');
        }
        String result = sb.toString();
        int index = 0;
        for (int i = 0;i < size;i++){
            if(result.charAt(i) != '0'){
                index = i;
                break;
            }else {
                index = i;
            }
        }
        return result.indexOf("0") == 0 && result.length()>1?result.substring(index):result;
    }

    public static void main(String[] args) {
//        String num = "1432219";
//        String num = "0432219";
//        int k = 3;
        String num = "100";
        int k = 1;
//        String num = "996414363788153611534713021581934201828636847894114849949764848271145953346100425440564423705308160608336170309768131340987930561551032020085493444465193544083073070710550651127384420202284715693947961741503230801612259019643388373415242532432185095002546192236830917993656777205823895681565852256661971230933778711000024814024862198372554113821624993211934165249722752734719691558487424574765564337372811477100217812101347653217612856122765119173245525855698821566350946703626535675961447286537950070232309338175661044886376964501660879051008236994257987635984443260693570528423799185358552969157600544593174335218787781718110810765931666630909480297931136268524627123881164837747134261839114812308843935942493318281655037982696342444307736930338827080002496328501487998593220246931465776355431146576624189988605175259891929732507016317655984650530976168048173443438950167245619478608361175049157970111851326742552782365977460421387684737230598259483015657194376107329076625454990429534998668137411";
//        int k = 100;
        System.out.println(removeKdigits(num, k));
        System.out.println(maxNumberK(num, k));
    }
}
