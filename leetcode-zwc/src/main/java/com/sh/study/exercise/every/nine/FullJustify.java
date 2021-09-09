package com.sh.study.exercise.every.nine;


import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * 通过次数21,742提交次数44,654
 *
 * @author zhouwenchen
 * @date 2021/9/9 9:36
 **/
public class FullJustify {

    /**
     * https://leetcode-cn.com/problems/text-justification/solution/wen-ben-zuo-you-dui-qi-by-leetcode-solut-dyeg/
     * 根据题目中填充空格的细节，我们分以下三种情况讨论：
     *
     * 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格；
     * 当前行不是最后一行，且只有一个单词：该单词左对齐，在行末填充空格；
     * 当前行不是最后一行，且不只一个单词：设当前行单词数为 \textit{numWords}numWords，空格数为 \textit{numSpaces}numSpaces，
     *
     * TODO 没搞明白啥子情况
     * @param words
     * @param maxWidth
     * @return
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int right = 0,n = words.length;
        while (true){
            int left = right;
            int sumLen = 0;// 统计这一行单词长度的总和，单词和单词之间至少有一个空格
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth){
                sumLen += words[right++].length();
            }

            // 当前行是最后一行的话
            if(right == n){
                StringBuffer sb = join(words,left,n," ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpace = maxWidth - sumLen;

            // 当前行只有一个单词，该单词左对其，在行末填充剩余空格
            if(numWords == 1){
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpace));
                ans.add(sb.toString());
                continue;
            }

            // 当前行不仅仅只有一个单词
            int avgSapce = numSpace /(numWords - 1);
            int extraSpace = numSpace % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words,left,left + extraSpace + 1,blank(avgSapce + 1)));
            sb.append(blank(avgSapce));
            sb.append(join(words,left + extraSpace + 1,right,blank(avgSapce)));
            ans.add(sb.toString());
        }
    }

    private static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    private static StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1;i < right; i++){
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        /**
         * [
         *    "This    is    an",
         *    "example  of text",
         *    "justification.  "
         * ]
         */
        fullJustify(words,maxWidth).stream().forEach(System.out::println);
    }
}
