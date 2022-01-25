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

    /**
     * 2029. 石子游戏 IX
     * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。
     *
     * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。
     *
     * 如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
     * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
     * 假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：stones = [2,1]
     * 输出：true
     * 解释：游戏进行如下：
     * - 回合 1：Alice 可以移除任意一个石子。
     * - 回合 2：Bob 移除剩下的石子。
     * 已移除的石子的值总和为 1 + 2 = 3 且可以被 3 整除。因此，Bob 输，Alice 获胜。
     * 示例 2：
     *
     * 输入：stones = [2]
     * 输出：false
     * 解释：Alice 会移除唯一一个石子，已移除石子的值总和为 2 。
     * 由于所有石子都已移除，且值总和无法被 3 整除，Bob 获胜。
     * 示例 3：
     *
     * 输入：stones = [5,1,2,4,3]
     * 输出：false
     * 解释：Bob 总会获胜。其中一种可能的游戏进行方式如下：
     * - 回合 1：Alice 可以移除值为 1 的第 2 个石子。已移除石子值总和为 1 。
     * - 回合 2：Bob 可以移除值为 3 的第 5 个石子。已移除石子值总和为 = 1 + 3 = 4 。
     * - 回合 3：Alices 可以移除值为 4 的第 4 个石子。已移除石子值总和为 = 1 + 3 + 4 = 8 。
     * - 回合 4：Bob 可以移除值为 2 的第 3 个石子。已移除石子值总和为 = 1 + 3 + 4 + 2 = 10.
     * - 回合 5：Alice 可以移除值为 5 的第 1 个石子。已移除石子值总和为 = 1 + 3 + 4 + 2 + 5 = 15.
     * Alice 输掉游戏，因为已移除石子值总和（15）可以被 3 整除，Bob 获胜。
     *
     *
     * 提示：
     *
     * 1 <= stones.length <= 105
     * 1 <= stones[i] <= 104
     * @param stones
     * @return
     */
    public static boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }


    public static void main(String[] args) {
//        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
    }
}
