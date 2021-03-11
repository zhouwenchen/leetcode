package com.sh.study.exercise.every.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 A[]，每个位置 i 放置了金币 A[i]，小明从 A[0] 出发。当小明走到 A[i] 的时候，下一步他可以选择 A[i+1, i+k]（当然，不能超出数组边界）。每个位置一旦被选择，将会把那个位置的金币收走（如果为负数，就要交出金币）。请问，最多能收集多少金币？
 *
 * 输入：[1,-1,-100,-1000,100,3], k = 2
 *
 * 输出：4
 *
 * 解释：从 A[0] = 1 出发，收获金币 1。下一步走往 A[2] = -100, 收获金币 -100。再下一步走到 A[4] = 100，收获金币 100，最后走到 A[5] = 3，收获金币 3。最多收获 1 - 100 + 100 + 3 = 4。没有比这个更好的走法了。
 *
 * 滑动窗口
 *
 */
public class MaxResult {

    public static int maxResult(int[] A, int k) {
        int m = A.length;
        if(m == 0){
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[m];
        ans[0] = A[0];
        for (int i = 0; i < m; i++) {
            if( i -k > 0 && !deque.isEmpty() && deque.getFirst() == ans[i-k-1]){
                deque.removeFirst();
            }
            // 从单调队列中获取到最大值
            int old = deque.isEmpty()? 0: deque.getFirst();
            ans[i] = old + A[i];

            // 入队列,如果新的元素比最大值大的话，队首先出队列，然后入队列
            if(!deque.isEmpty() && deque.getLast() < ans[i]){
                deque.removeLast();
            }
            deque.addLast(ans[i]);
        }
        return ans[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1, -1, -100, -1000, 100, 3}, 2));
    }
}