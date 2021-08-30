package com.sh.study.exercise.eight;

import java.util.Arrays;

/**
 *
 * 881. 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 *
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 *
 * @author zhouwenchen
 * @date 2021/8/30 11:49
 **/
public class NumRescueBoats {
    /**
     * 将体重排序，如果最轻的人能够和最重的人一起乘坐一条船的话，那么相对来说也就是最好的一对组合
     *
     * @param people
     * @param limit
     * @return
     */
    public static int numRescueBoats(int[] people, int limit) {
        // 先排序
        Arrays.sort(people);
        int left = 0,right = people.length -1;
        int count = 0;
        while (left <= right){
            if(people[left] + people[right] <= limit){
                ++left;
            }
            --right;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] people = new int[]{3,2,2,1};   // 3
//        int limit = 3;
//        int[] people = new int[]{3,5,3,4};   // 4
//        int limit = 5;
        int[] people = new int[]{5,1,4,2};   // 2
        int limit = 6;
//        int[] people = new int[]{3,2,3,2,2}; // 3
//        int limit = 6;
        System.out.println(numRescueBoats(people, limit));
    }
}
