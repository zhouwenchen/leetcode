package com.sh.study.exercise.weekly.competition216;

/**
 * 5607. 生成平衡数组的方案数
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 *
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 *
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 *
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/22 10:54
 */
public class WaysToMakeFair {
    /**
     * 分别计算奇数和偶数的和
     * 然后去除一个元素之后，需要判断剩下的元素的奇数和偶数位的和
     * @param nums
     * @return
     */
    public static int waysToMakeFair(int[] nums) {
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < nums.length;i++){
            if(i % 2 == 0){
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }

        int count = 0;
        int odd = 0;
        int even = 0;

        // 再次遍历数据，此时删除某一个位置的元素值，然后判断剩下的奇数和偶数位置的和是否相等
        for (int i = 0; i < nums.length;i++){
            int newOdd = 0;
            int newEven = 0;
            if(i % 2 == 0){
                newEven = even + oddSum - odd;
                newOdd = odd + evenSum - even - nums[i];
                if(newEven == newOdd){
                    count++;
                }
                even += nums[i];
            } else{
                newEven = even + oddSum - odd - nums[i];
                newOdd = odd + evenSum -even;
                if(newEven == newOdd){
                    count++;
                }
                odd +=nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{6, 1, 7, 4, 1}));
        System.out.println(waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(waysToMakeFair(new int[]{1,1,1}));
    }
}
