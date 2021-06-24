package com.sh.study.exercise.every.five;

/**
 * 1723. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 *
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *
 *
 * 提示：
 *
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 *
 * @author zhouwenchen
 * @date 2021/5/8 9:51
 **/
public class MinimumTimeRequired {

    /**
     * 最小的  工人最大用时
     */
    private static int minId = Integer.MAX_VALUE;
    /**
     *  回溯
     */
    public static int minimumTimeRequired(int[] jobs, int k) {
        backTracking(jobs,new int[k],0,0);
        return minId;
    }

    private static void backTracking(int[] jobs, int[] times, int m, int minTime) {
        // 如果工作已经完成分配了
        if(m == jobs.length){
            minId = Math.min(minId,minTime);
            return;
        }

        boolean flag = true;
        for (int i = 0; i < times.length;i++){
            if(times[i] == 0){
                if(!flag){
                    return;
                }
                flag = false;
            }

            times[i] += jobs[m];
            // 如果现在有工人用时超过了 minId，那么就不用判断了
            int tmpMax = Math.max(minTime,times[i]);
            if(tmpMax <= minId){
                backTracking(jobs,times,m+1,tmpMax);
            }
            times[i] -=jobs[m];
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumTimeRequired(new int[]{3, 2, 3}, 3));
    }
}
