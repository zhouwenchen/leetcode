package com.sh.study.exercise.every.ten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * @author zhouwenchen
 * @date 2021/10/13 9:42
 **/
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i < 2){
                result.add(i+"");
            }else if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }else if(i % 3 == 0){
                result.add("Fizz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else {
                result.add(i+"");
            }
        }
        return result;
    }

    /**
     * 特别简便的方式实现操作
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz1(int n) {
        return IntStream.range(1, n + 1).mapToObj(o -> o % 15 == 0 ? "FizzBuzz" : o % 3 == 0 ? "Fizz" : o % 5 == 0 ? "Buzz" : String.valueOf(o)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        fizzBuzz1(15).stream().forEach(System.out::println);
    }
}
