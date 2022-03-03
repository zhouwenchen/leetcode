package com.sh.study.exercise.every.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * @author zhouwenchen
 * @date 2022/3/1 9:53
 **/
public class Convert {

    public static String convert(String s, int numRows) {
        // 二维矩阵
        if(numRows < 2) return s;
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuffer());
        }
        int i = 0,flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows - 1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuffer row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
