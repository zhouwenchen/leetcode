package com.sh.study.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/19 19:32
 */
public class KSmallestPairs {
    /**
     * 第一种想法： 先全排列，然后使用堆排序遍历获取到和最小的k对数字，这种效率不好，因为原数组就是已经排好序的
     * 第二种想法： 直接比较两个数组，将比较小的进行组合
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        // 参数验证
        if(nums1 == null || nums2 == null){
            return result;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] value = new int[n1 * n2][2];
        int index = 0;
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length;j++){
                value[index][0] = nums1[i];
                value[index][1] = nums2[j];
                index++;
            }
        }
        // 排序
        Arrays.sort(value,(o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));
        // 取前k个
        for (int i = 0; i < Math.min(k,value.length);i++){
            List<Integer> list = new ArrayList<>();
            list.add(value[i][0]);
            list.add(value[i][1]);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3).forEach(o->{ o.stream().forEach(b->System.out.print(b + "\t"));
            System.out.println();});
    }
}
