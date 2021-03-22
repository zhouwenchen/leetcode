package com.sh.study.exercise.every.three;

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
 */
public class KSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        k = Math.min(k,nums1.length * nums2.length);
        if(k == 0){
            return res;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o2[0] + o2[1])-(o1[0] + o1[1]));
        for (int e1: nums1){
            for (int e2:nums2){
                if(queue.size() < k){
                    queue.offer(new int[]{e1,e2});

                } else if(e1 + e2 < queue.peek()[0] + queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{e1,e2});
                }
            }
        }
        while (k-- > 0){
            int[] e = queue.poll();
            res.add(0,Arrays.asList(e[0],e[1]));
        }
        return res;
    }

    public static void main(String[] args) {
        kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3).stream().forEach(data->data.stream().forEach(o-> System.out.print(o+"\t")));
    }
}
