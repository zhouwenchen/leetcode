package com.sh.study.exercise.weekly.week41;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 5610. 有序数组中差绝对值之和
 *
 * 给你一个 非递减 有序整数数组 nums 。
 *
 * 请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
 *
 * 换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,5]
 * 输出：[4,3,5]
 * 解释：假设数组下标从 0 开始，那么
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
 * 示例 2：
 *
 * 输入：nums = [1,4,6,8,10]
 * 输出：[24,15,13,15,21]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/12 22:40
 */
public class GetSumAbsoluteDifferences {
    /**
     *
     * @param nums
     * @return
     */
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        if(nums == null || nums.length == 1){
            return nums;
        }
        int[] result = new int[nums.length];
        // 判断是否有相同的元素
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length;i++){
            if(map.getOrDefault(nums[i],0) != 0){
                result[i] = map.get(nums[i]);
                continue;
            }
            int  j = 0;
            int sum = 0;
            while (j < nums.length ){
                if(i != j && j < nums.length){
                    if(nums[i] == nums[j]){
                        j++;
                        continue;
                    }
                    sum += Math.abs(nums[i] -nums[j]);
                }
                j++;
            }
            result[i] = sum;
            map.put(nums[i],sum);
        }

        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(getSumAbsoluteDifferences(new int[]{2,3,5})).forEach(System.out::println);
        Arrays.stream(getSumAbsoluteDifferences(new int[]{1,4,6,8,10})).forEach(System.out::println);
        Arrays.stream(getSumAbsoluteDifferences(new int[]{1,1,1,1,1,1,1,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,5,5,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,9,9,9,9,9,9,10,10,10,11,11,11,11,11,11,11,12,12,12,12,12,12,13,13,13,13,13,13,14,14,14,14,14,14,14,14,14,14,14,14,14,15,15,16,16,16,16,17,17,17,17,17,18,18,18,18,18,18,18,19,19,19,19,19,19,19,20,21,21,21,21,21,21,22,22,22,23,23,23,23,24,24,24,24,24,24,25,25,25,25,25,26,26,26,26,27,27,27,27,27,27,27,28,28,28,28,29,29,29,29,29,29,29,29,29,30,30,30,31,31,31,31,31,31,31,32,32,32,33,33,33,})).forEach(System.out::println);
    }
}
