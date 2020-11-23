package com.sh.study.exercise.every;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/23 9:42
 */
public class FindMinArrowShots {
    /**
     * 根据第一个元素进行排序，
     * 遍历排好序的数组，每个数组分为 start ，end ，第一个元素end 如果大于第二个 start 的话，说明一个箭就可以了
     *
     * TODO 以下的方式解决不了这个问题
     */
    public static int findMinArrowShots(int[][] points) {
        int count = 0;
        // 根据数组的第一个元素进行排序
        Arrays.sort(points,(o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        // 再次遍历数组，如果第一个元素的end 大于等于第一个start的话，count++
//        if(points.length == 1){
//            return 1;
//        }
        for (int i = 0; i < points.length;){
            if(i  < points.length - 1 && points[i][1] >= points[i+1][0]){
                count++;
                i+=2;
            } else {
                count++;
                i++;
            }
        }
        return count;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/yong-zui-shao-shu-liang-de-jian-yin-bao-qi-qiu-1-2/
     * @param points
     * @return
     */
    public static int findMinArrowShots1(int[][] points) {
        // 根据数组的第一个元素进行排序
        Arrays.sort(points,(o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points){
            if(balloon[0] > pos){
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] points = new int[][]{
//            {10,16},
//            {2,8},
//            {1,6},
//            {7,12}
//        }; // 2

//        int[][] points = new int[][]{
//                {1,2},
//                {2,3},
//                {3,4},
//                {4,5}
//        };// 2
//        int[][] points = new int[][]{
//                {1,2}
//        };// 2

//        int[][] points = new int[][]{
//                {2,3},
//                {2,3},
//        }; // 1

//        int[][] points = new int[][]{
//                {1,2},
//                {3,4},
//                {5,6},
//                {7,8}
//        };// 2

        int[][] points = new int[][]{
                {-2147483646,-2147483645},
                {2147483646,2147483647}
        };// 2

        System.out.println(findMinArrowShots(points));

    }
}
