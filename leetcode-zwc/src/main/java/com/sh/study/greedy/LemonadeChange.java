package com.sh.study.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 *
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 *
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *
 *
 * 提示：
 *
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20
 *
 * @Author zhouwenchen
 * @Data 2020/9/11/11
 **/
public class LemonadeChange {

    /**
     * 这个题很简单，直接分类就可以做出来！还好没有设置一元的！
     * 如果收到五元的，就直接放你口袋里面！
     * 如果收到十元的，你只能用一张五元的钞票找给顾客！所以直接将五元的钞票张数减一，十元的钞票张数加一！
     *
     * 如果收到二十元的：
     * 你有两种选择，用一张十元的和一张五元的找给顾客！也就是五元的钞票张数减一，十元的钞票张数减一！
     * 第二种方法就是，找给他三张五元的，所以直接五元的钞票张数减三！
     *
     * 作者：yi-dai-mi-kang-ji-lou
     * 链接：https://leetcode-cn.com/problems/lemonade-change/solution/jian-dan-de-jie-fa-zhi-jie-mo-ni-chang-jing-jiu-ke/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    five--;
                    ten++;
                    break;
                case 20: {
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                    break;
                }
                default:
                    break;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] bills = new int[]{5,5,5,10,20};
        int[] bills = new int[]{5,5,5,5,20,20,5,5,5,5};
        System.out.println(lemonadeChange(bills));
    }
}
