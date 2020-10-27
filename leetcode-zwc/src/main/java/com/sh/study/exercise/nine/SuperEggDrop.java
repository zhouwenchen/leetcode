package com.sh.study.exercise.nine;

/**
 * 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 *
 * @Author zhouwenchen
 * @Data 2020/10/27/16
 **/
public class SuperEggDrop {

    /**
     * 使用动态规划实现操作
     * 详看文章  https://blog.csdn.net/weixin_39795049/article/details/97611644?biz_id=102&utm_term=%E9%B8%A1%E8%9B%8B%E6%8E%89%E8%90%BD&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-97611644&spm=1018.2118.3001.4187
     * 状态转移方程式：
     *
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int m = 1;m <= N;m++){
            dp[0][m] = 0;
            for (int k = 1;k <=K;k++){
                dp[k][m] = dp[k][m-1]+dp[k-1][m-1]+1;
                if (dp[k][m] >=N){
                    return m;
                }
            }
        }
        return N;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 2));
    }
}
