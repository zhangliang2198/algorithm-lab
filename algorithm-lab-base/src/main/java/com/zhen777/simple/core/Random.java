package com.zhen777.simple.core;

import com.zhen777.simple.Util;

/**
 * 随机
 *
 * @author zhang
 * @date 2023/02/23
 */
public class Random {
    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() --> [0,1) 等概率

        // 测试等概率
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        // 一种算区间的概率方式 8等分，大于5的概率
        System.out.println("===========================");
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 > 5) {
                count++;
            }
        }
        System.out.println((double) (8 - 5) / (double) 8);
        System.out.println((double) count / (double) testTimes);

        // Math.random() * N  =  [0,N)等概率 ，再转换成整形 [0,N-1]
        // 验证
        System.out.println("===========================");
        int[] ans = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int in = (int) (Math.random() * 9);
            ans[in]++;
        }
        Util.printArray(ans);

        System.out.println("===========================");
        // 对于 x ，[0,x) 出现的概率是 x平方，怎么计算
        count = 0;
        double test = 0.7;
        for (int i = 0; i < testTimes; i++) {
            // 2 次都落在  0.7 范围内，相当于平方了，同理 3次方一样的道理
            if (xToXPower2() < test) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(test * test);
    }

    private static double xToXPower2() {
        // 算落到 [0,x) 不方便计算，算不落到落到 [0,x)的概率
        return Math.max(Math.random(), Math.random());
    }
}
