package com.sh.study.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 例 3：找出数组中右边比我小的元素
 * 【题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 * <p>
 * 输入：[5, 2]
 * 输出：[1, -1]
 * <p>
 * 输入：[1,2,4,9,4,0,5]
 * 输出：[5,5,5,4,-1,-1]
 */
public class FindRightSmall {

    public static int[] findRightSmall(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中记录的是元素记录的下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 如果 stack 不为 空,且当前的元素之大于栈顶的元素的话，
            while (!stack.isEmpty() && A[stack.peek()] > x) {
                // 消除的时候，记录一下谁被消除了
                ans[stack.peek()] = i;
                // 消除的时候，栈中较大的值删除
                stack.pop();
            }
            stack.push(i);
        }

        // 剩下的元素入栈
        while (!stack.isEmpty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(findRightSmall(new int[]{1, 2, 4, 9, 4, 0, 5})).forEach(data -> System.out.print(data + "\t"));
    }
}
