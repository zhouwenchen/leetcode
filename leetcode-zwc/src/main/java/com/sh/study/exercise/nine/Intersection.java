package com.sh.study.exercise.nine;

import java.util.*;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * @Author zhouwenchen
 * @Data 2020/11/2/09
 **/
public class Intersection {

    /**
     * 数据测试
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums1){
            map.put(num,map.getOrDefault(num, 1));
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2){
            if(map.containsKey(num)&& !list.contains(num)){
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,2,1};
        int[] num2 = new int[]{2,2};
        Arrays.stream(intersection(num1, num2)).forEach(System.out::println);
    }
}
