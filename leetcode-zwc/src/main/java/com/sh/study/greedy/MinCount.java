package com.sh.study.greedy;

/**
 * LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * 示例 1：
 *
 * 输入：[4,2,1]
 *
 * 输出：4
 *
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * 示例 2：
 *
 * 输入：[2,3,10]
 *
 * 输出：8
 *
 * 限制：
 *
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 * @Author zhouwenchen
 * @Data 2020/8/20/19
 **/
public class MinCount {

    /**
     * 循环遍历链表中的每一个元素
     * 计算的是最少的次数，那么我们假定每次都两个，所需要的次数最少
     * @param coins
     * @return
     */
    public static int minCount(int[] coins) {
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i]%2== 0){
                sum += coins[i] /2;
            }else {
                sum += coins[i]/2 + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,2,1};
        int[] nums = new int[]{2,3,10};
        int i = minCount(nums);
        System.out.println(i);
    }
}