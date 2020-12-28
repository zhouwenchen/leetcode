package com.sh.study.exercise.weekly.competition221;

import java.util.Arrays;

/**
 * 5640. 与数组中元素的最大异或值
 *
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 *
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 *
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 *
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 * @author ：zhouwenchen
 * @date ： 2020/12/27 10:46
 */
public class MaximizeXor {

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4};
        int[][] queries = new int[][]{
                {3,1},
                {1,3},
                {5,6},
        };

        Arrays.stream(maximizeXor(nums, queries)).forEach(data->{
            System.out.println(data);
        });
    }
}
