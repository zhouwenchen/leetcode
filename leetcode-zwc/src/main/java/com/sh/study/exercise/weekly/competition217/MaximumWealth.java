package com.sh.study.exercise.weekly.competition217;

/**
 * 5613. 最富有客户的资产总量 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 *
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 *
 *
 * 示例 1：
 *
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 * 示例 2：
 *
 * 输入：accounts = [[1,5],[7,3],[3,5]]
 * 输出：10
 * 解释：
 * 第 1 位客户的资产总量 = 6
 * 第 2 位客户的资产总量 = 10
 * 第 3 位客户的资产总量 = 8
 * 第 2 位客户是最富有的，资产总量是 10
 * 示例 3：
 *
 * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出：17
 *
 *
 * 提示：
 *
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 * @author ：zhouwenchen
 * @date ： 2020/11/29 10:30
 */
public class MaximumWealth {
    /**
     * 计算和
     * @param accounts
     * @return
     */
    public static int maximumWealth(int[][] accounts) {
        if(accounts==null || accounts.length== 0){
            return 0;
        }
        int m = accounts.length;
        int n = accounts[0].length;
        int max = 0;
       for (int i = 0; i < m; i++){
           int sum = 0;
           for (int j = 0; j < n; j++){
               sum+=accounts[i][j];
           }
           max = Math.max(sum,max);
       }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{
                {1,2,3},
                {3,2,1}
        };
        System.out.println(maximumWealth(accounts));
    }
}
