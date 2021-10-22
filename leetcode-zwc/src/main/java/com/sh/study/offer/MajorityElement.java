package com.sh.study.offer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 *
 *
 * @author zhouwenchen
 * @date 2021/9/28 10:07
 **/
public class MajorityElement {

    /**
     * 1：如果进行计数统计的话，很容易获取
     * 2：排序，那么中间的元素，一定是最多元素的个数
     * hash 的方法也是可行的
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        return nums[mid];
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num: nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate)? 1: -1;
        }
        return candidate;
    }


    /**
     * 229. 求众数 II
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：[3,2,3]
     * 输出：[3]
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：[1]
     * 示例 3：
     *
     * 输入：[1,1,1,3,3,2,2,2]
     * 输出：[1,2]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 5 * 104
     * -109 <= nums[i] <= 109
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement2(int[] nums) {
        // 统计出现所有元素的个数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key: map.keySet()){
            if(map.get(key) > nums.length / 3){
                list.add(key);
            }
        }
        return list;
    }

    public static List<Integer> majorityElement3(int[] nums) {
        int max = nums.length / 3;
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() > max)
                .map(e->e.getKey())
                .collect(Collectors.toList());
    }

    public static List<Integer> majorityElement4(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(k->k,v->1,Integer::sum))
                .entrySet()
                .stream()
                .filter(o->o.getValue() > nums.length / 3)
                .map(o->o.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
//        System.out.println(majorityElement1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));

//        majorityElement2(new int[]{1,1,1,3,3,2,2,2}).stream().forEach(o-> System.out.print(o+"\t"));
        majorityElement3(new int[]{1,1,1,3,3,2,2,2}).stream().forEach(o-> System.out.print(o+"\t"));
    }
}
