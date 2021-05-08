package com.sh.study.exercise.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 先看 300 最长递增子序列
 *
 * @author zhouwenchen
 * @date 2021/4/23 10:53
 **/
public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer>[] dp = new ArrayList[nums.length];
        Arrays.sort(nums);
        int maxNum = 0;
        for (int i = 0;i < nums.length;i++){
            // 创建自己的结果集
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);

            // 开始寻找最大的子集
            int index = -1;
            int subMax = -1;

            for (int j = i -1;j >= 0;j--){
                if(nums[i] % nums[j] == 0){
                    if(subMax < dp[i].size()){
                        subMax = dp[j].size();
                        index = j;
                    }
                }
            }

            // 如果找到了，就逐个添加
            if(index != -1){
                for (Integer num: dp[index]){
                    dp[i].add(num);
                }
                maxNum = Math.max(maxNum, dp[i].size());
            }
        }

        //对最后结果的处理
        for(int i = 0; i < nums.length; i++){
            if(dp[i].size() == maxNum)
                return dp[i];
        }
        return null;
    }


    /**
     * 返回长度
     * @param nums
     * @return
     */
    public static int largestDivisibleSubset1(int[] nums){
        // 先对数组进行排序
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(nums,1);
        int max = 1;
        for (int i = 1; i < nums.length;i++){
            for (int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    public static List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);

        int max = 1;
        int maxIndex = 0;//记录最大整除子集中最后一个元素的位置
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //这里大于号我们改为求余
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    //说明nums[i]可以放到nums[j]后面构成一个更长的整除子集,
                    //也就是[……，……，……，nums[j]，nums[i]]。注意dp[i]记录
                    //的整除子集中，nums[i]一定是数组的最后一个元素，我们用prev[i]
                    //来记录这个子集中nums[i]的前一个元素的位置，也就是nums[j]的位置
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            //如果找到更大的子集，就记录最大的即可
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        //把找到的最大整除子集加入到list中，prev很类似于链表，每一个都是记录
        //前一个的位置
        List<Integer> res = new ArrayList<>();
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return res;
    }

    public static void main(String[] args) {
        largestDivisibleSubset2(new int[]{1,2,4,8}).stream().forEach(o-> System.out.print(o+"\t"));
//        System.out.println(largestDivisibleSubset1(new int[]{1, 2, 4, 8}));
    }
}
