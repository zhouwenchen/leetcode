package com.sh.study.exercise.weekly.competition215;

/**
 * 5602. 将 x 减到 0 的最小操作数 显示英文描述
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 *
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 *
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/15 10:52
 */
public class MinOperations {
    /**
     * 滑动窗口
     * 数组的和为sum ，那么窗口的最大值为 win = sum - x
     * 如果当前的窗口 w > win,就尝试即移动窗口的左边沿，缩小窗口，即start 增大
     * 如果当前窗口 w = win, start + nums.length -1 -i(也就是窗口区域的大小)
     *
     * @param nums
     * @param x
     * @return
     */
    public static int minOperations(int[] nums, int x) {
       int sum = 0;
       for (int num: nums){
           sum += num;
       }
       if(sum == x){
           return nums.length;
       }
       int win = sum -x;
       int w = 0;
       int start = 0;
       int min = Integer.MAX_VALUE;
       for (int i = 0; i < nums.length;i++){
           w +=nums[i];
           if(w > win){
               // 缩小窗口
               while ( start < i && w > win ){
                   w -= nums[start];
                   start++;
               }
           }
           if(w == win){
               min = Math.min(min,start + nums.length - 1 - i);
           }
       }
        return min == Integer.MAX_VALUE?-1:min;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }
}
