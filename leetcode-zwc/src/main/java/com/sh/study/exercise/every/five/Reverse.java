package com.sh.study.exercise.every.five;

/**
 * @author zhouwenchen
 * @date 2021/5/3 23:28
 **/
public class Reverse {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0){
            if(rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


    public static void main(String[] args) {
//        System.out.println(reverse(123));
        int a = 3;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
