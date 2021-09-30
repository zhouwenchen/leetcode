package com.sh.study.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * @author zhouwenchen
 * @date 2021/9/29 14:37
 **/
public class FindContinuousSequence {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 0,limit = (target - 1)/ 2;
        for (int i = 1; i <= limit; i++){
            for (int j = i; ; j++) {
                sum += j;
                if(sum > target){
                    sum = 0;
                    break;
                }else if(sum == target){
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        res[k-i] = k;
                    }
                    list.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Arrays.stream(findContinuousSequence(9)).forEach(o->{
            Arrays.stream(o).forEach(t->{
                System.out.print(t+"\t");
            });
            System.out.println();
        });
    }
}
