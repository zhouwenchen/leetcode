package com.sh.study.exercise.every.six;

/**
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 * @author zhouwenchen
 * @date 2021/6/29 9:27
 **/
public class ConvertToTitle {

    /**
     * TODO 则个是错误的
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        String result = "";
        while (columnNumber > 26){
            int tmp = columnNumber / 26;
            columnNumber = columnNumber % 26;
            result += (char) (tmp + 'A'-1) + "";
        }
        if (columnNumber < 26){
            result += (char) (columnNumber + 'A'-1) + "";
        }
        return result;
    }

    public static String convertToTitle1(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0){
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));

        // TODO
        System.out.println(convertToTitle1(2147483647));
    }
}
