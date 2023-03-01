package com.zhen777.simple.core;

import com.zhen777.simple.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class KMTimesFind {
    /**
     * [0,max)区间的随机数
     *
     * @param max 马克斯
     * @return int
     */
    private static int makeNumber(int max) {
        return (int) (Math.random() * max);
    }

    private static int[] makeArray(int max, int k, int m, int total) {
        HashMap<Integer, Integer> check = new HashMap<>(16);
        int[] res = new int[k + (total - 1) * m];

        // 先处理出现k的数
        int aNumber = makeNumber(max);
        for (int i = 0; i < k; i++) {
            res[i] = aNumber;
        }
        check.put(aNumber, k);

        // 还剩 total - 1 个数
        for (int j = 0; j < total - 1; j++) {
            aNumber = makeNumber(max);
            while (check.containsKey(aNumber)) {
                aNumber = makeNumber(max);
            }
            // 每个数出现m次
            for (int i = 0; i < m; i++) {
                res[k + j * m + i] = aNumber;
            }
        }

        // 打乱顺序
        for (int i = 0; i < res.length; i++) {
            int newIndex = (int) (Math.random() * res.length);
            Util.swapArray1(res, i, newIndex);
        }
        return res;
    }

    public static void main(String[] args) {
        // 2,3
        for (int i = 0; i < 100000; i++) {
            int[] test = test();
            if (test[2] != test[3]) {
                System.out.print("测试不通过:");
                System.out.println(test[0] + "," + test[1] + "," + test[2] + "," + test[3]);
                break;
            }
        }

        System.out.println("测试完成");
    }

    public static int[] test() {
        int radomk = makeNumber(9) + 1;
        int radomM = radomk + (makeNumber(9) + 1);

        // 2,3
        int[] arr = makeArray(90, radomk, radomM, 100);
        return new int[]{radomk, radomM, findKM(arr, radomk, radomM), findKMStupid(arr, radomk, radomM)};
    }


    /**
     * 一种数出现K次，其他都出现了M次，求K和M的值
     *
     * @param arr 加勒比海盗
     * @return {@link int[] }
     */
    private static int findKM(int[] arr, int k, int m) {
        int[] bitMap = new int[32];
        for (int j : arr) {
            // 在 [0,0,0,0,0,0,0,0,-----]共32位，累加数组里面二进制,得到每个位数为1的总是【9,12,15,12......】
            for (int i = 0; i < 32; i++) {
                bitMap[i] += (((j >> i) & 1) == 1) ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < bitMap.length; i++) {
            res = res | ((bitMap[i] % m == 0) ? 0 : (1 << i));
        }
        return res;
    }

    private static int findKMStupid(int[] arr, int k, int m) {
        int res = -1;
        // 得到，数:次数 的map
        Map<Integer, Integer> check = new HashMap<>(32);
        for (int j : arr) {
            if (check.containsKey(j)) {
                check.put(j, check.get(j) + 1);
            } else {
                check.put(j, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : check.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == k) {
                res = key;
            }
        }
        if (res == -1) {
            System.out.println(111);
        }
        return res;
    }
}
