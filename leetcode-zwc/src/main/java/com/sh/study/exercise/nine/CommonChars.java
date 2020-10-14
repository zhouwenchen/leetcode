package com.sh.study.exercise.nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * @Author zhouwenchen
 * @Date  2020-10-14
 **/
public class CommonChars {

    /**
     * 先统计每个字符串中每个字符出现的次数
     * 获取并集，
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        if(A== null){
            return null;
        }

        int[] minfreq = new int[26];
        Arrays.fill(minfreq,Integer.MAX_VALUE);
        for (String a:A){
            int[] freq = new int[26];
            char[] chars = a.toCharArray();
            for (char t: chars){
                freq[t-'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26;i++){
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        commonChars(new String[]{"bella","label","roller"}).forEach(System.out::print);
    }
}
