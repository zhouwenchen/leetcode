package com.sh.study.exercise.seven;

import java.util.*;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *
 *
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 *
 * @Author zhouwenchen
 * @Date  2020-09-27
 **/
public class Merge {

    /**
     * 使用动态规划操作
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len < 2){
            return intervals;
        }

        // 按照起点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<int[]>();
        res.add(intervals[0]);

        for(int i = 0; i < len; i++){
            int[] cur = intervals[i];
            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);
            if(cur[0] > peek[1]){
                res.add(cur);
            } else {
                peek[1] = Math.max(cur[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Arrays.stream(merge(intervals)).forEach(o-> System.out.println(Arrays.toString(o)));
    }
}
