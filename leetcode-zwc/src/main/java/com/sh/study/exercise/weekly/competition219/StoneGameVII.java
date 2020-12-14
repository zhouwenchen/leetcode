package com.sh.study.exercise.weekly.competition219;

/**
 * 5627. 石子游戏 VII
 *
 * 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
 *
 * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
 *
 * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
 *
 * 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [5,3,1,4,2]
 * 输出：6
 * 解释：
 * - 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
 * - 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
 * - 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
 * - 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
 * - 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
 * 得分的差值 18 - 12 = 6 。
 * 示例 2：
 *
 * 输入：stones = [7,90,5,1,100,10,10,2]
 * 输出：122
 *
 *
 * 提示：
 *
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/13 11:03
 */
public class StoneGameVII {
    /**
     * A 和 B，
     * A移除最小值，返回最大值
     * B移除最大值，返回较小值，但是当数组中的元素等于2的时候，删除较小值
     *
     * TODO 未实现操作,这个没有解决问题
     * @param stones
     * @return
     */
    public static int stoneGameVII(int[] stones) {
        // 求和
        int sum = 0;
        for (int stone:stones){
            sum += stone;
        }
        int left = 0;
        int right = stones.length-1;
        int aSum = 0;
        int bSum = 0;
        boolean flag = true;
        // 先a开始
        while (left < right){
           if(stones[left] < stones[right]){
               if(flag){
                   flag = false;
                   aSum += (sum - stones[left]);
                   sum -= stones[left];
                   left++;
               } else {
                   // 最后两个元素，删除最小值，获得最大值
                   if(right - left > 1){
                       flag = true;
                       bSum += (sum - stones[right]);
                       sum -= stones[right];
                       right--;
                   }else{
                       bSum += (sum-stones[left]);
                       left++;
                   }
               }
           } else {
               if(flag){
                   flag = false;
                   aSum += (sum - stones[right]);
                   sum -= stones[right];
                   right--;
               } else {
                   if(right - left > 1){
                       flag = true;
                       bSum += (sum - stones[left]);
                       sum -= stones[left];
                       left++;
                   } else{
                       bSum += (sum-stones[right]);
                       right--;
                   }
               }
           }
        }
        return aSum-bSum;
    }

    /**
     * 使用动态规划实现操作
     * @param stones
     * @return
     */
    private static int[] nums;
    public static int stoneGameVII1(int[] stones) {
        int n = stones.length;
        nums = stones;
        Integer[][] dp = new Integer[n][n];
        int sum = 0;
        // 先求和
        for (int s: nums){
            sum += s;
        }
        return slove(dp,0,n-1,sum);
    }

    private static int slove(Integer[][] dp, int l, int r, int sum) {
        if(l >= r){
            return 0;
        }
        if(dp[l][r] != null){
            return dp[l][r];
        }

        int lr = -slove(dp,l+1,r,sum- nums[l] ) + sum - nums[l];
        int rr = -slove(dp,l,r-1,sum-nums[r]) + sum - nums[r];
        return dp[l][r] = Math.max(lr,rr);
    }

    /**
     * 使用动态规划操作
     * @param stones
     * @return
     */
    public static int stoneGameVII2(int[] stones) {

        return 0;
    }


    public static void main(String[] args) {
//        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
    }
}
