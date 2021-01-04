package com.sh.study.exercise.every.one;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 * @Author zhouwenchen
 * @Date
 **/
public class MaxSlidingWindow {
    /**
     * TODO 以下这种方式会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null){
            return null;
        }
        // 先满足k个数组的要求
        int[] result = new int[nums.length -k + 1];
        int[] need = new int[k];
        int left = 0;
        int right = 0;
        int m = 0;
        for (; m < k; m++){
            need[m] = nums[m];
        }
        right = m;
        int index = 0;
        while (left < right){
            // 查找最大值
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k;i++){
                max =  Math.max(need[i],max);
            }
            result[index] = max;
            index++;

            // need 判断是否需要右移
            if(right == nums.length ){
                break;
            }
            left +=1;
            int j = 0;
            int i = left;
            for (; i < left+k; i++){
                need[j++] = nums[i];
            }
            right = i;
        }
        return result;
    }

    /**
     *
     * 使用优先级队列实现，堆顶永远是最大的值
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        /**
         * 队列中存储数组，数组中第一个表示元素中的数值，数组中的地热个元素表示的是 在原数组的索引下标的位置
         */
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1 != o2 ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k;i++){
            queue.add(new int[]{nums[i],i});
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        ans[0] = queue.peek()[0];
        for (int i = k;i < n;i++){
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1] <= i-k){
                queue.poll();
            }
            ans[i-k+1] = queue.peek()[0];
        }
        return ans;
    }

    /**
     * 方法二：单调队列
     *
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0;i < k;i++){
            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n;i++){
            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
//        Arrays.stream(maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).forEach(System.out::println);
//        Arrays.stream(maxSlidingWindow1(new int[]{1}, 1)).forEach(System.out::println);
        Arrays.stream(maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).forEach(System.out::println);
    }
}
