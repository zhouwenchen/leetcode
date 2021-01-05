package com.sh.study.exercise.weekly.competition222;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1710. 卡车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 *
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 *
 * 返回卡车可以装载 单元 的 最大 总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 *
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 *
 * @Author zhouwenchen
 * @Date
 **/
public class MaximumUnits {
    /**
     * 优先级队列
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // 根据 boxTypes 中数组的第一个元素进行排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] != o2[1]? o2[1]-o1[1]:o1[0]-o2[0]);
        Arrays.stream(boxTypes).forEach(queue::add);
        int max = 0;
        int count = 0;
        while (!queue.isEmpty() && count < truckSize){
            int[] values = queue.poll();
            if(truckSize - (count + values[0]) > 0){
                max += values[0] * values[1];
                count += values[0];
            } else {
                max += (truckSize- count) * values[1];
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{
                {2, 2},
                {3, 1},
                {1, 3},
        };
        int truckSize = 4;

//        int[][] boxTypes = new int[][]{
//                {5,10},{2,5},{4,7},{3,9}
//        };
//        int truckSize = 10;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
