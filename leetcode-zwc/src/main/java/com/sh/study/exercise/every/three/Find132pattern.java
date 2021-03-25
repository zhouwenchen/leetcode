package com.sh.study.exercise.every.three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 456. 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 注意：n 的值小于15000。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 4]
 * <p>
 * 输出: False
 * <p>
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 * <p>
 * 输入: [3, 1, 4, 2]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 * <p>
 * 输入: [-1, 3, 2, 0]
 * <p>
 * 输出: True
 * <p>
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 * @author zhouwenchen
 * @date 2021/3/24 9:49
 **/
public class Find132pattern {
    /**
     * TOTDO 实现不了
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.push(nums[0]);
        int firstValue = deque.peek();
        // 表示栈中此时从什么位置开始的
        int firstIndex = 0;
        int sencodeIndex = 1;
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            if (deque.size() == 1) {
                if (value > deque.peek()) {
                    deque.push(value);
                }
                if(i == n-1){
                    deque.pop();
                    firstIndex++;
                    i = firstIndex;
                    sencodeIndex = firstIndex+1;
                    firstValue = nums[firstIndex];
                    deque.push(nums[i]);
                }
            } else if (deque.size() == 2) {
                // 判断第三个数字是否满足
                if (deque.peek() > value && value > firstValue) {
                    // 第三个数是否大于第一个数
                    return true;
                }
                // 如果此时 i == n -1 ，说明此时cur已经遍历完了，我们需要将第二个数出栈，继续比较
                if (i == n - 1 && n - sencodeIndex > 3) {
                    // sencode 出栈
                    deque.pop();
                    while (sencodeIndex < n - 2) {
                        if (deque.peek() < nums[++sencodeIndex]) {
                            deque.push(nums[sencodeIndex]);
                            continue;
                        }
                    }

                    // 没有找到的话，需要将deque 清空
                    deque.pop();
                    firstIndex++;
                    sencodeIndex = firstIndex + 1;
                    i = firstIndex;
                    firstValue = nums[i];
                    deque.push(firstValue);

                }
                // 如果此时 i == n -1 ，说明此时cur已经遍历完了，我们需要找其他的了
                if (i == n - 1 && n - firstIndex > 3) {
                    // 先清空 deque
                    while (!deque.isEmpty()) {
                        deque.pop();
                    }
                    firstIndex++;
                    i = firstIndex;
                    sencodeIndex = firstIndex + 1;
                    deque.push(nums[i]);
                    firstValue = nums[i];
                }
            } else {
                // 第一次存入数据
                deque.push(value);
            }

        }
        return false;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern1(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--){
            if(nums[i] < k) return true;
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                k = Math.max(k,deque.pollLast());
            }
            deque.addLast(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern1(new int[]{1, 2, 3, 4})); // false
        System.out.println(find132pattern1(new int[]{-1, 3, 2, 0})); // true
        System.out.println(find132pattern1(new int[]{3, 1, 4, 2})); // true
        System.out.println(find132pattern1(new int[]{-2,1,2,-2,1,2}));// true
        System.out.println(find132pattern1(new int[]{1, 4, 0, -1, -2, -3, -1, -2}));// true
    }
}
