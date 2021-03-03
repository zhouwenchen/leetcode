package com.sh.study.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 例 4：取出最小的数
 * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中最小的 k 个。
 *
 * 输入：nums = [3,5,2,6], k = 2
 *
 * 输出：[2,6]
 *
 * 假定输入为[9, 2, 4, 5, 1, 2, 3, 0], k = 3.输出能构成的最小的序列。
 * 输出：[1,2,0]
 */
public class FindSmallSeq {

    public static int[] findSmallSeq(int[] nums, int k) {
        int[] ans = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final int left = nums.length - i;

            // 如果栈中元素不满足 k个，直接入栈
           while (!stack.isEmpty() && (stack.size() + left > k) && stack.peek() > x){
               stack.pop();
           }
           stack.push(x);
        }

        // 需要将stack 中的数据取出存入到 ans，注意顺序
       for (int i = k-1;i>= 0;i--){
           ans[i] = stack.peek();
           stack.pop();
       }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(findSmallSeq(new int[]{9, 2, 4, 5, 1, 2, 3, 0},3)).forEach(o->System.out.print(o+"\t"));
    }
}
