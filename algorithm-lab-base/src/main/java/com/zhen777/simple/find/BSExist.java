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
        int[] arr = Util.makeArray(20, 20);
        BubbleSort.bubbleSort(arr);
        int needFind = (int) (Math.random() * 20);
        Util.printArray(arr);
        System.out.println("要查找：" + needFind);

        int res = nearestIndex(arr, needFind);
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

        // 当 L=R的时候，还剩最后一个没有验证。或者可以使用 while(L<=R)，应该是一样的效果
        return arr[L] == number ? L : -1;
    }


    /**
     * 查最左最小值
     *
     * @param arr    加勒比海盗
     * @param number 数量
     * @return int
     */
    private static int nearestIndex(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        // 等同 (L+R)/2 但不会有 int 溢出问题
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= number) {
                index = (arr[mid] == number) ? mid : index;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;
    }
}
