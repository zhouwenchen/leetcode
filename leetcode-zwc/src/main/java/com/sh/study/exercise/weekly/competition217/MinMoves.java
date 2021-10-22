package com.sh.study.exercise.weekly.competition217;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 5615. 使数组互补的最少操作次数

 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 *
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
 *
 * 返回使数组 互补 的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,4,3], limit = 4
 * 输出：1
 * 解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
 * nums[0] + nums[3] = 1 + 3 = 4.
 * nums[1] + nums[2] = 2 + 2 = 4.
 * nums[2] + nums[1] = 2 + 2 = 4.
 * nums[3] + nums[0] = 3 + 1 = 4.
 * 对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
 * 示例 2：
 *
 * 输入：nums = [1,2,2,1], limit = 2
 * 输出：2
 * 解释：经过 2 次操作，你可以将数组 nums 变成 [2,2,2,2] 。你不能将任何数字变更为 3 ，因为 3 > limit 。
 * 示例 3：
 *
 * 输入：nums = [1,2,1,2], limit = 2
 * 输出：0
 * 解释：nums 已经是互补的。
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/29 10:41
 */
public class MinMoves {

    /**
     * 差分数组
     * TODO 没有搞明白
     * https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary/solution/chai-fen-shu-zu-by-xiaobanni/
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int minMoves(int[] nums, int limit) {
       int n = nums.length;
       int[] d = new int[2 * limit + 2];
       for (int i = 0; i < n / 2;i++){
           int left = 1+ Math.min(nums[i],nums[n-1-i]);
           int right = limit + Math.max(nums[i],nums[n-1-i]);
           d[left] -=1;
           d[right+1] +=1;
           d[nums[i] + nums[n-1-i]] -=1;
           d[nums[i] + nums[n-1-i] +1] +=1;
       }
       d[2]+=n;
       int res =d[2];
        for(int i=3;i<=2*limit;i++){
            d[i]=d[i]+d[i-1];
            res=Math.min(res,d[i]);
        }

        return res;
    }

    /**
     *
     * 453. 最小操作次数使数组元素相等
     * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：3
     * 解释：
     * 只需要3次操作（注意每次操作会增加两个元素的值）：
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     * 示例 2：
     *
     * 输入：nums = [1,1,1]
     * 输出：0
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * @param nums
     * @param limit
     * @return
     */
    public static int minMoves1(int[] nums, int limit) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num: nums){
            res += num - min;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(minMoves(new int[]{1, 2, 4, 3}, 4));
//        System.out.println(minMoves(new int[]{1, 2, 4, 3}, 4));

    }
}
