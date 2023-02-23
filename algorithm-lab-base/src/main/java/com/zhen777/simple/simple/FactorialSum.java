package com.zhen777.simple.simple;

/**
 * 阶乘总和
 *
 * @author zhang
 * @date 2023/02/22
 */
public class FactorialSum {
    public static void main(String[] args) {
        int number = 3;
        long result = factorialSum(number);
        System.out.println("结果是：" + result);
    }

    private static long factorialSum(int i) {
        int factorial = 1;
        long total = 0;
        for (int j = 1; j <= i; j++) {
            factorial = factorial * j;
            total = total + factorial;
        }
        return total;
    }
}
