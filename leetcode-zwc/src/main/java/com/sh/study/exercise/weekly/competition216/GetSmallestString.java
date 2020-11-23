package com.sh.study.exercise.weekly.competition216;

import com.sh.study.queue.ArrayQueue;
import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 5606. 具有给定数值的最小字符串 显示英文描述
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 *
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 *
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 *
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 *
 * x 是 y 的一个前缀；
 * 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 27
 * 输出："aay"
 * 解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
 * 示例 2：
 *
 * 输入：n = 5, k = 73
 * 输出："aaszz"
 *
 *
 * 提示：
 *
 * 1 <= n <= 105
 * n <= k <= 26 * n
 * @author ：zhouwenchen
 * @date ： 2020/11/22 10:49
 */
public class GetSmallestString {
    /**
     * 回溯
     * 容易超时，这种方式不可取，获取不到正确的结果，需要重新获取数据
     *
     * @param n
     * @param k
     * @return
     */
    public static String getSmallestString(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> resultdequeue = new ArrayDeque<>();

        def(n,k,deque,resultdequeue);
        // 转化成 String
        StringBuilder sb = new StringBuilder();
        while (!resultdequeue.isEmpty()){
            Integer value = resultdequeue.poll();
            sb.append((char) (value.intValue() + 48 + '0'));
        }
        return sb.toString();
    }

    private static void def(int n, int k, Deque deque,Deque resultdequeue) {
        if(n == 0 && k == 0){
            resultdequeue.addAll(deque);
            return;
        }
        for (int i = 1; i <= 26; i++) {
            if(n == 0 && k != 0 || !resultdequeue.isEmpty()){
                System.out.println();
                break;
            }
            deque.addLast(i);
            k -= i;
            def(n-1, k, deque,resultdequeue);
            // 回溯
            deque.removeLast();
            k += i;
        }
    }

    /**
     * 使用第二种方式实现操作
     *
     * @param n
     * @param k
     * @return
     */
    public static String getSmallestString1(int n, int k) {
        int[] nums = new int[n];
        Arrays.fill(nums,1);
        k = k - n;
        // 从后向前遍历获取数据
        int index = n - 1;
        while ( k != 0 && index < n){
            if(nums[index] != 26){
                nums[index]++;
                k--;
            } else {
                index--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int num:nums){
            res.append((char)('a' + num - 1));
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        System.out.println(getSmallestString1(3, 27));
        System.out.println(getSmallestString1(24,552));
//        System.out.println('z'-'a' + 1);
//
//        System.out.println((char) (49 + '0'));
    }
}
