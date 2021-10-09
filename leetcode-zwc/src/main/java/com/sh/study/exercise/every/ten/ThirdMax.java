package com.sh.study.exercise.every.ten;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * @author zhouwenchen
 * @date 2021/10/9 11:18
 **/
public class ThirdMax {

    /**
     * set 去重
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if(set.contains(num)) continue;

            if(priorityQueue.size() < 3){
                priorityQueue.add(num);
            }else if(priorityQueue.peek() < num){
                priorityQueue.poll();
                priorityQueue.add(num);
            }
            set.add(num);
        }
        // 如果没有第三大的值，返回最大值
        int max = 0;
        if(priorityQueue.size() < 3){
            while (!priorityQueue.isEmpty()){
                max = Math.max(max,priorityQueue.poll());
            }
            return max;
        }
        return  priorityQueue.poll();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax(new int[]{2, 3, 1}));
        System.out.println(thirdMax(new int[]{2, 1}));
        System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
