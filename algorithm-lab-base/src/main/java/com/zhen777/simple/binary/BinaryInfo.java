package com.zhen777.simple.binary;

public class BinaryInfo {
    public static void main(String[] args) {
        System.out.println("有符号最大值：" + Integer.MAX_VALUE);// 2^31-1
        System.out.print("有符号最大值二进制：");
        PrintBinary.printBinary(Integer.MAX_VALUE);

        System.out.println();
        System.out.println("有符号最小值："+Integer.MIN_VALUE); // 2^31
        System.out.print("有符号最小值二进制：");
        PrintBinary.printBinary(Integer.MIN_VALUE);

        System.out.println();
        System.out.print("负数二进制：");// 符号位不管，其他位按位取反
        PrintBinary.printBinary(-3);

        System.out.println();
        System.out.print("最小值的负数：");// 等于自己
        PrintBinary.printBinary(~Integer.MIN_VALUE+1);
        System.out.println();
        System.out.print("最小值的负数：");// 等于自己
        PrintBinary.printBinary(-Integer.MIN_VALUE);

        System.out.println("负数算法");// 等于自己
        PrintBinary.printBinary(-3);
        PrintBinary.printBinary(~3+1);
    }
}
