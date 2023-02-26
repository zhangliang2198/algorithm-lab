package com.zhen777.simple.find;

import com.zhen777.simple.Util;
import com.zhen777.simple.sort.BubbleSort;

import java.util.Random;

/**
 * 二分查找
 *
 * @author zhang
 * @date 2023/02/26
 */
public class BSExist {
    public static void main(String[] args) {
        int[] arr = Util.makeArray(30, 20);
        BubbleSort.bubbleSort(arr);
        int needFind = (int) (Math.random() * 30);
        Util.printArray(arr);
        System.out.println("要查找：" + needFind);

        int res = isExist(arr, needFind);
        System.out.println(res);
    }

    private static int isExist(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        // 等同 (L+R)/2 但不会有 int 溢出问题
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == number) {
                return mid;
            } else if (arr[mid] > number) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }
}
