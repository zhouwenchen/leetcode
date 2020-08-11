package com.sh.study.recursive;

import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Author zhouwenchen
 * @Data 2020/8/11/16
 **/
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {

        return null;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 4});
        lists.stream().forEach(list->list.stream().forEach(o-> System.out.print(o+"\t")));
    }
}
