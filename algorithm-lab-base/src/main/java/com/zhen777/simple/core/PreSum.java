package com.zhen777.simple.core;

import com.zhen777.simple.Util;

/**
 * 前缀和
 *
 * @author zhang
 * @date 2023/02/23
 */
public class PreSum {
    private final static int[] arr = Util.makeArray(100, 50);
    private static int[] preSumArr;
    private static int[][] preMap;

    static {
        Util.printArray(arr);
        // 预先生成[15,59,47,78,90,57,5,79,68,41,77,23,99,9,52,49,36,95,11,70,72,79,54,73,84,84,77,11,84,98,24,85,73,50,16,53,9,75,9,44,6,87,44,34,79,21,27,48,84,12]
        preSumArr = preSum(arr);
        preMap = preSumMap(arr);
        Util.printArray(preSumArr);
    }

    private static int[][] preSumMap(int[] arr) {
        int[][] res = new int[arr.length][arr.length];
        for (int l = 0; l < arr.length; l++) {
            for (int r = 0; r < arr.length; r++) {
                if (l > r) {
                    res[l][r]=0;
                    continue;
                }
                if (l == r) {
                    res[l][r] = arr[r];
                    continue;
                }
                res[l][r] = res[l][r - 1] + arr[r];
            }
        }
        return res;
    }

    /**
     * 生成前缀和数组
     *
     * @return {@link int[]}
     */
    private static int[] preSum(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = arr[i] + res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int res = sumRange(12, 22);
        int res1 = sumMap(12, 22);
        System.out.println(res);
        System.out.println(res1);
    }

    /**
     * 求数组的区间累加
     * 只用相减即可
     */
    private static int sumRange(int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l <= 0) {
            return preSumArr[r];
        }
        return preSumArr[r] - preSumArr[l - 1];
    }

    private static int sumMap(int l, int r) {
        return preMap[l][r];
    }
}
