package com.sh.study.exercise.nine;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 * @Author zhouwenchen
 * @Data 2020/10/26/09
 **/
public class SmallerNumbersThanCurrent {
    /**
     * 思路1：先排序，，然后就可以统计了，
     *       问题1：但是这个顺序就乱，相同的元素就没办法了，
     *
     * 思路2：使用 treeMap，根据key排序
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null){
            return nums;
        }
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>((o1,o2)-> o2 - o1);
        for (int key : nums){
            if(map.get(key) != null){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key, 1);
            }
        }
        int len = nums.length;
        int count = len;
        // 统计map中每个元素中比多少个元素大的个数
        for (Integer key : map.keySet()) {
            count -= map.get(key);
            map.put(key, count);
        }

        // 再次遍历
        int[] result = new int[len];
        for (int i = 0;i < len;i++){
            Integer value = map.get(nums[i]);
            result[i] = value;
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})).forEach(System.out::println);
    }
}
