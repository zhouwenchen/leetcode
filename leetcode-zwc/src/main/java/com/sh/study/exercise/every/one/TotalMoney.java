package com.sh.study.exercise.every.one;

/**
 * 1716. 计算力扣银行的钱
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 *
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 *
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 *
 * @author zhouwenchen
 * @date 2022/1/17 15:18
 **/
public class TotalMoney {
    /**
     * 如果超过一周的话，也就是7的倍数，total = (1+...+7) = 28;
     *               第二周也满的话 total = 28 + (2+...8) = 28 + (28 + 7) = 63
     *                           total = 28 + (2+...8) = 28 +(7 * 0) + (28 + 7 * 1) = 63
     *               如果是10的话，total = 28 + (2 + 3 + 4) = 37
     *               第20天的话，  total = 28 + 28
     *               第26天的话，  total = 28 + (28 + 7) + (28 + 7 + 7) + (4 + 5 + 6 + 7 + 8)
     *
     * @param n
     * @return
     */
    public static int totalMoney(int n) {
//        if (n <= 7) {
//            return ((1 + n) * n) / 2;
//        }
//        int count = n / 7;
//        int temp = n % 7;
//        if (temp == 0) {
//            return 28 * count + (count - 1) * 7;
//        } else {
//            return 28 * count + (((count ) * count) / 2) * 7 + (((count + 1) + (count + temp)) * temp) / 2;
//        }

        int week = 1,day = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += week + day - 1;
            ++day;
            if(day == 8){
                day = 1;
                ++week;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(14));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
        System.out.println(totalMoney(26));
    }
}
