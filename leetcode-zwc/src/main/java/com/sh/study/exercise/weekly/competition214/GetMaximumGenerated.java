package com.sh.study.exercise.weekly.competition214;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 1646. 获取生成数组中的最大值 显示英文描述
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 *   nums[0] = 0
 *   nums[1] = 1
 *   nums[(1 * 2) = 2] = nums[1] = 1
 *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 *   nums[(2 * 2) = 4] = nums[2] = 1
 *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 *   nums[(3 * 2) = 6] = nums[3] = 2
 *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/17 10:23
 */
public class GetMaximumGenerated {

    private static int[] nums = new int[101];

    public static int getMaximumGenerated(int n){
        if(n == 0){
            return 0;
        }
        for (int i = 1; i <= n; i++){
            getMaximumGenerated1(i);
        }
        Arrays.sort(nums);
        return nums[100];

    }
    /**
     * 需要判断是奇数还是偶数
     * @param n
     * @return
     */
    public static int getMaximumGenerated1(int n) {
        if( n == 0){
            nums[0] = 0;
        }
        if( n == 1){
            nums[1] = 1;
        }

        // 判断奇偶性
        if(n >=2){
            // 偶数
            if(n % 2 == 0){
                if(nums[n/2]!= 0){
                    return nums[n/2];
                } else{
                    nums[n] = getMaximumGenerated1(n / 2);
                    return nums[n];
                }
            } else{
                // 奇数
                if(nums[n/2]!=0 && nums[n/2+1] != 0){
                    nums[n]  = nums[n / 2] + nums[n / 2 + 1];
                    return nums[n];
                } else if(nums[n/2]!=0 && nums[n/2+1] == 0) {
                    nums[n] = getMaximumGenerated1(n/2+1) + nums[n/2];
                    return nums[n];
                } else if(nums[n/2]==0 && nums[n/2+1] != 0) {
                    nums[n] = getMaximumGenerated1(n/2) + nums[n/2+1];
                    return nums[n];
                } else {
                    nums[n] = getMaximumGenerated1(n/2) + getMaximumGenerated1(n/2+1);
                    return nums[n];
                }
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
//        System.out.println(getMaximumGenerated(7));
        System.out.println(getMaximumGenerated(1));
//        System.out.println(getMaximumGenerated(15));
    }
}
