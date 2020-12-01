package com.sh.study.exercise.weekly.competition217;

import java.util.*;

/**
 * 5614. 找出最具竞争力的子序列

 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 *
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 *
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 *
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/29 10:36
 */
public class MostCompetitive {
    /**
     * 单调栈的实现
     * https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/solution/dan-diao-zhan-by-jin-ai-yi/
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        if(n == k){
            return nums;
        }
        stack.add(nums[0]);
        for (int i = 1; i < n;i++){
            if(n-i > k-stack.size()){
                if(stack.peek() > nums[i]){
                    while (!stack.isEmpty() && stack.peek() > nums[i] && n -i > k-stack.size()){
                        stack.pop();
                    }
                    stack.push(nums[i]);
                } else{
                    if(k != stack.size()){
                        stack.push(nums[i]);
                    }
                }
            } else{ // 没有选择的余地，必须把所有的元素都加上
                while (i < n){
                    stack.push(nums[i]);
                    i++;
                }
                break;
            }
        }
        // 封装数据
        int[] res = new int[k];
        for (int i = k -1; i >= 0;i--){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,6};
        Arrays.stream(mostCompetitive(nums, 2)).forEach(System.out::println);
    }

}
