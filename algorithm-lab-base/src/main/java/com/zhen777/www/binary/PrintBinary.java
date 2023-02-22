package com.zhen777.www.binary;

/**
 * 打印二进制表示
 *
 * @author zhang
 * @date 2023/02/22
 */
public class PrintBinary {
    public static void main(String[] args) {
        int number = 12;
        printBinary(number);
    }

    public static void printBinary(int number) {
        String res = "";
        for (int i = 31; i >= 0; i--) {
            String current = (number & 1 << i) == 0 ? "0" : "1";
            System.out.print(current);
        }
        System.out.println();
    }
}
