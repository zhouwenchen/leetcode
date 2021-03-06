package com.sh.study.exercise.six;

import netscape.security.UserTarget;

/**
 * 403. 青蛙过河
 * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
 *
 * 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
 *
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 请注意：
 *
 * 石子的数量 ≥ 2 且 < 1100；
 * 每一个石子的位置序号都是一个非负整数，且其 < 231；
 * 第一个石子的位置永远是0。
 * 示例 1:
 *
 * [0,1,3,5,6,8,12,17]
 *
 * 总共有8个石子。
 * 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
 * 第三个石子在序号为3的单元格的位置， 以此定义整个数组...
 * 最后一个石子处于序号为17的单元格的位置。
 *
 * 返回 true。即青蛙可以成功过河，按照如下方案跳跃：
 * 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着
 * 跳2个单位到第4块石子, 然后跳3个单位到第6块石子,
 * 跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。
 * 示例 2:
 *
 * [0,1,2,3,4,8,9,11]
 *
 * 返回 false。青蛙没有办法过河。
 * 这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * @Author zhouwenchen
 * @Date  2020-09-17
 **/
public class CanCross {

    /**
     * 动态规划：
     * dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
     *
     * @param stones 石头数组
     * @return
     */
    public static boolean canCross(int[] stones) {
        if(stones == null){
            return false;
        }

        int len = stones.length;
        boolean[][] dp = new boolean[len][len+1];
        // base case
        dp[0][0] = true;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                int k = stones[i] - stones[j];
                if(k <=i){
                    dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                }
            }
        }

        for (int j = 0; j < stones.length + 1; j++) {
            if (dp[stones.length - 1][j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 20210429
     *
     * @param stones
     * @return
     */
    public static boolean canCross1(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
//        int[] stones = new int[]{0,1,2,3,4,8,9,11};
//        System.out.println(canCross(stones));
        System.out.println(canCross1(stones));
    }
}
