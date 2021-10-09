package com.sh.study.exercise.every.ten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * @author zhouwenchen
 * @date 2021/10/8 10:12
 **/
public class FindRepeatedDnaSequences {

    /**
     * 使用 hash 统计的方式统计实现
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        List<String> ans = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").stream().forEach(System.out::println);
        findRepeatedDnaSequences("AAAAAAAAAAA").stream().forEach(System.out::println);
    }
}
