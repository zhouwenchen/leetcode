package com.sh.study.exercise.every.one;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 *
 * @author zhouwenchen
 * @date 2022/1/19 14:42
 **/
public class FindMinDifference {

    public static int findMinDifference(List<String> timePoints) {
        // 还有一个鸽巢原理，秀
        if(timePoints.size() > 1440){
            return 0;
        }
        int[] result = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] arr = timePoints.get(i).split(":");
          result[i] = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        }
        //
        Arrays.sort(result);
        // 如果有相同的时间，那肯定是最近的，也就是0
        int[] tmp = new int[result.length];
        tmp[0] = result[0];
        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
        for (int i = 1; i < result.length; i++) {
            tmp[i] = result[i]-result[i-1];
            min = Math.min(tmp[i],min);
//            max = Math.max(tmp[i],max);
        }
        // 排序，第一个元素不能算,从第二个元素找到最小值，但是如果最大值很大的话，需要重新计算最大值和最小值的差距
        if(min == 0){
            return 0;
        }
        // 还要计算一次 最小值和最大值，和min 比较即可
        min = Math.min(result[0] + 1440 - result[result.length - 1],min);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(findMinDifference(Arrays.asList("00:00","23:59","00:00")));
        System.out.println(findMinDifference(Arrays.asList("00:00","00:02","00:05","23:55")));
    }
}
