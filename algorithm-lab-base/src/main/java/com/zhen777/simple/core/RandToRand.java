package com.zhen777.simple.core;

import com.zhen777.simple.Util;

public class RandToRand {
    public static void main(String[] args) {
        int testTime = 100000;
        int res[] = new int[10];
        for (int i = 0; i < testTime; i++) {
            res[getNewIntRandom1()]++;
        }
        Util.printArray(res);
    }

    // 得到 0-7 等概率
    private static int getNewIntRandom() {
        int n = 5;
        int res = 0;
        return (getBinary(n) << 2) + (getBinary(n) << 1) + (getBinary(n));
    }

    // 得到 0-8 等概率
    private static int getNewIntRandom1() {
        int n = 5;
        int res = (getBinary(n) << 3) + (getBinary(n) << 2) + (getBinary(n) << 1) + (getBinary(n));
        if (res <= 8) {
            return res;
        }
        return getNewIntRandom1();
    }

    // 由getRandom 1-5 的随机，产生一个0，1发生器
    private static int getBinary(int n) {
        int random = getRandom(n);
        int mid = n / 2;
        if (random <= mid) {
            return 0;
        } else if (random > mid + (n % 2)) {
            return 1;
        }
        return getBinary(n);
    }

    // 等概率得到1 - n之间的随机数
    private static int getRandom(int n) {
        // 算落到 [0,x) 不方便计算，算不落到落到 [0,x)的概率
        return 1 + (int) (Math.random() * n);
    }
}
