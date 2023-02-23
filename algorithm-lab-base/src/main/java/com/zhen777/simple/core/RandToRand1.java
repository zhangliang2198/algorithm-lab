package com.zhen777.simple.core;

import com.zhen777.simple.Util;

public class RandToRand1 {
    public static void main(String[] args) {
        int testTimes = 100000;
        int arr[] = new int[2];
        for (int i = 0; i < testTimes; i++) {
            arr[f2()]++;
        }
        Util.printArray(arr);
    }

    // 概率不等的发生器
    private static int f1() {
        return Math.random() < 0.83 ? 1 : 0;
    }

    // 概率相等等的发生器
    private static int f2() {
        int ans;
        do {
            ans = f1();
        } while (ans == f1());
        return ans;
    }
}
