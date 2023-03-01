package com.zhen777.simple.core;

import com.zhen777.simple.Util;

public class TwoOddTimesFind {
    public static void main(String[] args) {
        // 2,3
        int[] arr = new int[]{1, 2, 3, 4, 1, 1, 1, 2, 2, 5, 9, 5, 9, 5, 5, 1, 2, 8, 9, 2, 8, 3, 8, 4, 3, 9, 2, 8, 4, 9, 1, 4, 9, 1};
        Util.printArray(find2Odd(arr));
    }


    /**
     * 已确保给定的数组满足，只有2种树，出现了奇数次，其他都出现偶数次，边界条件不用处理
     *
     * @param arr 加勒比海盗
     * @return {@link int[] }
     */
    private static int[] find2Odd(int[] arr) {
        int[] res = new int[2];
        int eor = 0;

        // 先求出这两个数的XOR，偶数次的数XOR后结果为0，不用管
        for (int j : arr) {
            eor ^= j;
        }

        // 提取最右边的一个1，返回为000000-000100000，其中只有一个1，也说明两个奇数次的数，当前位置一定有一个是1，一个是0
        int rightOne = eor & (-eor);

        // 再来一次,得到 rightOne 来区分当前位
        int eor1 = 0;
        for (int j : arr) {
            // 所有为1的数【其中一个奇数，加上当前位为1的偶数次的数】
            if ((j & rightOne) > 0) {
                eor1 ^= j;
            }
        }
        res[0] = eor1;

        // eor = eor1 ^eor2，再次eor1 ^eor2 ^eor1 = eor2
        res[1] = eor ^ eor1;
        return res;
    }
}
