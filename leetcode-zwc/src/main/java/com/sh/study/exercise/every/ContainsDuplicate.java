package com.sh.study.exercise.every;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/13 21:35
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums){
            if(map.getOrDefault(num,0) == 1){
                return true;
            } else{
                map.put(num,1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }
}
