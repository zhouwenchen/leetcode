package com.sh.study.exercise.nine;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * @Author zhouwenchen
 * @Data 2020/10/22/09
 **/
public class PartitionLabels {
    /**
     * 第一次遍历获取到对应每个字符出现对应的位置
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len;i++){
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0;  i < len;i++){
            end = Math.max(end, last[S.charAt(i)-'a']);
            if(i == end){
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
