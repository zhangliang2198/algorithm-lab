package com.zhen777.simple.simple;

/**
 * 异或
 *
 * @author zhang
 * @date 2023/02/27
 */
public class XORExChange {
    public static void main(String[] args) {
        int a = 12;
        int b = 16;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

}
