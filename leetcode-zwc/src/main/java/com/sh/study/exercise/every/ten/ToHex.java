package com.sh.study.exercise.every.ten;


/**
 *
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 *
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 * 示例 2：
 *
 * 输入:
 * -1
 *
 * 输出:
 * "ffffffff"
 *
 * @author zhouwenchen
 * @date 2021/10/8 13:52
 **/
public class ToHex {
    /**
     * 正数喝负数得区别
     * @param num
     * @return
     */
    public static String toHex(int num) {
        if(num == 0){
            return "0";
        }
        long tmp = num;
        // 负数得解决方法
        if(num < 0){
            tmp = (long) (Math.pow(2,32) + tmp);
        }
        StringBuilder builder = new StringBuilder();
        while (tmp != 0){
            long u = tmp % 16;
            char c = (char) (u+'0');
            if(u>=10){
                c = (char) (u-10+'a');
            }
            builder.append(c);
            tmp /=16;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26)); // 1a
    }
}