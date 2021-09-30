package com.sh.study.offer;

import java.util.*;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/27 10:28
 **/
public class SingleNumbers {

    public static int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.getOrDefault(nums[i],0) == 0){
                map.put(nums[i],1);
            }else {
                map.remove(nums[i]);
            }
        }
        Iterator<Integer> its = map.keySet().iterator();
        int index = 0;
        while (its.hasNext()){
             result[index++]=its.next();
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
     *
     * @param nums
     */
    public static int[] singleNumbers1(int[] nums) {
        int ret = 0;
        // 获取两个异或的值
        for(int num: nums){
            ret ^= num;
        }
        int div = 1;
        while ((div & ret) == 0){
            div <<= 1;
        }
        int a = 0,b = 0;
        for (int num: nums){
            if((div & num) != 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

    /**
     * 剑指 Offer 56 - II. 数组中数字出现的次数 II
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *
     *
     * 限制：
     *
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        // 还是使用hash的方式实现
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            if(map.getOrDefault(num,0) == 2){
                map.remove(num);
            }else {
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }

        return map.keySet().iterator().next();
    }

    /**
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     * @param nums
     * @return
     */
    public static int singleNumber22(int[] nums) {
        int one = 0, two = 0;
        for (int num: nums){
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
       return one;
    }

    public static void main(String[] args) {
//        Arrays.stream(singleNumbers(new int[]{4, 1, 4, 6})).forEach(System.out::println);
//        Arrays.stream(singleNumbers1(new int[]{1,2,10,4,1,4,3,3})).forEach(System.out::println);
        System.out.println(singleNumber2(new int[]{9, 1, 7, 9, 7, 9, 7}));
        System.out.println(singleNumber22(new int[]{9, 1, 7, 9, 7, 9, 7}));
    }
}
