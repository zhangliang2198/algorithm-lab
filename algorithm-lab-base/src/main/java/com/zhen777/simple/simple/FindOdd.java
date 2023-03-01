package com.zhen777.simple.simple;

/**
 * 异或
 *
 * @author zhang
 * @date 2023/02/27
 */
public class FindOdd {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 2, 3, 3, 4};

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }
}
