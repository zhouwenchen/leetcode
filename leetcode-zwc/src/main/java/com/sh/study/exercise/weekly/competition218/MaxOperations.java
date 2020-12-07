package com.sh.study.exercise.weekly.competition218;

import java.util.HashMap;
import java.util.Map;

/**
 * 5618. K 和数对的最大数目
 *
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/6 10:42
 */
public class MaxOperations {
    public static int maxOperations(int[] nums, int k) {
        if(nums == null){
            return 0;
        }
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length;i++){
            int target = k - nums[i];
            if(map.containsKey(target)){
                count++;
                if(map.get(target)==1){
                    map.remove(target);
                } else{
                    map.put(target,map.get(target)-1);
                }
            } else {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));//2
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 5));//2
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));//1
        System.out.println(maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));//3
    }
}
