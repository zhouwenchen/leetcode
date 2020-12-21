package com.sh.study.exercise.weekly.competition220;

import com.sh.study.queue.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 5629. 重新格式化电话号码
 *
 * 题目难度Easy
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * 请你按下述方式重新格式化电话号码。
 *
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 返回格式化后的电话号码。
 *
 *
 *
 * 示例 1：
 *
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 * 示例 2：
 *
 * 输入：number = "123 4-567"
 * 输出："123-45-67"
 * 解释：数字是 "1234567".
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
 * 连接这些块后得到 "123-45-67" 。
 * 示例 3：
 *
 * 输入：number = "123 4-5678"
 * 输出："123-456-78"
 * 解释：数字是 "12345678" 。
 * 步骤 1：第 1 个块 "123" 。
 * 步骤 2：第 2 个块 "456" 。
 * 步骤 3：剩下 2 个数字，将它们放入单个含 2 个数字的块。第 3 个块是 "78" 。
 * 连接这些块后得到 "123-456-78" 。
 * 示例 4：
 *
 * 输入：number = "12"
 * 输出："12"
 * 示例 5：
 *
 * 输入：number = "--17-5 229 35-39475 "
 * 输出："175-229-353-94-75"
 * @author ：zhouwenchen
 * @date ： 2020/12/20 10:30
 */
public class ReformatNumber {
    public static String reformatNumber(String number) {
        // 先格式化操作
        String replace = number.replaceAll("-", "").replace(" ", "");
        String[] chars = replace.split("");
        StringBuffer sb = new StringBuffer();
        int len = chars.length;
        if(len < 4){
            return replace;
        }
        for (int i = 0; i < chars.length;i++){
            if(len > 4){
                if(i%3 == 0){
                    sb.append("-");
                }
                sb.append(chars[i]);
            } else if(len - i == 4){
                // 只剩四个数字
                sb.append(chars[i]).append(chars[i+1]).append("-").append(chars[i+2]).append(chars[i+3]);
                break;
            }
        }
        String result = sb.toString();

        if(result.indexOf("-")==0){
            result = result.substring(1);
        }
        if(result.lastIndexOf("-") == result.length() -2){
            result = exchange(result, result.length() - 2, result.length() - 3);
        }

        return result;
    }

    public static String exchange(String target,int pos1, int pos2){
        if(pos2<pos1){
            int temp = pos2;
            pos2 = pos1;
            pos1 = temp;
        }
        if(pos1 == pos2||pos2 >= target.length()||pos1 <= -1){
            return target;
        }
        String str1 = target.substring(pos1,pos1+1);
        String str2 = target.substring(pos2,pos2+1);
        StringBuffer buf = new StringBuffer(target.length());
        return buf.append(target.substring(0,pos1)).append(str2)
                .append(target.substring(pos1+1,pos2)).append(str1)
                .append(target.substring(pos2+1)).toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("--17-5 229 35-39475 "));
        System.out.println(reformatNumber("--17-5 229"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4"));
        System.out.println(reformatNumber("12"));
    }
}
