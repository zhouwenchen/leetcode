package com.sh.study.exercise.every.one;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 747. 至少是其他数字两倍的最大数
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * <p>
 * <p>
 * 提示：
 * 3,6,1,0
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 *
 * @author zhouwenchen
 * @date 2022/1/17 17:21
 **/
public class DominantIndex {

    public static int dominantIndex(int[] nums) {
        if (nums != null && nums.length == 1) {
            return 0;
        }
        // 排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], i);
        }
        // 判断前两个是否满足，如果满足的话，返回最大值的索引位置
        Set<Integer> keys = treeMap.keySet();
        int index = 0;
        Integer max = 0;
        for (Integer key : keys) {
            if (index < 1) {
                max = key;
            } else if (max >= 2 * key) {
                return treeMap.get(max);
            }
            index++;
            if(index > 1){
                break;
            }
        }
        return -1;
    }

    public static int dominantIndex1(int[] nums) {
        int m1 = -1,m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > m1){
                m2 = m1;
                m1 = nums[i];
                index = i;
            }else if(nums[i] > m2){
                m2 = nums[i];
            }
        }
        return m1 > m2 * 2? index: -1;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
//        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
