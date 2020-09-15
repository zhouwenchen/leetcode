package com.sh.study.exercise.six;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @Author zhouwenchen
 * @Date  2020-09-15
 **/
public class Rob {

    /**
     * 思考：
     *  状态转移方程式: dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
     *  边界天剑：
     *      dp[0] = nums[0]:只有一间屋
     *      dp[1] = Math.max(nums[0],nums[1]);只有两间屋，判断其中的一个屋就可以了
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        // 表示一间屋
        if(n == 1){
            return nums[0];
        }
        // 大于等于两间屋
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < n; i++){
            // 状态转移方程式
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[n-1];
    }

    /**
     * 优化第一种动态规划的算法，使用滚动数组进行优化操作
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        // 参数校验
        if(nums == null || nums.length == 0){
            return 0;
        }
        // 只有一间房
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        // 大于等于 2间房屋
        int first = nums[0];
        int second  = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n; i++){
            int temp = second ;
            second  = Math.max(first + nums[i],second );
            first = temp;
        }
        return second ;
    }

    /**
     * 变种题型
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        // 验证参数
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        // 只有一个
        if(n == 1){
            return nums[0];
        }
        /**
         * TODO 第二种的方案的精髓之处
         *
         * 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，
         * 因此可以把此环状排列房间问题约化为两个单排排列房间子问题(198)：
         * 在不偷窃第一个房子的情况下（即 nums[1:]），最大金额是p1；
         * 在不偷窃最后一个房子的情况下（即 nums[:n-1]），最大金额是p2。
         * 综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)。
         */
        int max1 = rob22(nums,0,n-1);
        int max2 = rob22(nums,1,n);
        return Math.max(max1,max2);
    }

    /**
     *  这就转化成第一种解决方案了
     * @param nums
     * @param i
     * @param j
     * @return
     */
    private static int rob22(int[] nums, int i, int j) {
        // 状态转移方程式
        int first = 0;
        int second = 0;
        for(;i < j ; i++){
            int temp = second;
            second = Math.max(nums[i] + first,second);
            first = temp;
        }
        return second;
    }

    /**
     * 337. 打家劫舍 III
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     * @param root
     * @return
     */
    public static int rob3(TreeNode root) {
        int[] res = helper(root);

        return Math.max(res[0],res[1]);
    }

    private static int[] helper(TreeNode root) {
        if(root == null){
            return new int[2];
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int[] res = new int[2];
        //计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        // 表示清洁根节点
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
//        int[] nums = new int[]{2,7,9,3,1};
//        System.out.println(rob(nums));
//        System.out.println(rob1(nums));

        // 打家劫舍II，首位的警报是相连的
//        int[] nums1 = new int[]{2,3,2};
//        System.out.println(rob2(nums1));

        // 打家劫舍III ，二叉树房屋结构
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{3,4,5,1,3,-1,1});
        System.out.println(rob3(root));
    }
}
