package com.zhen777.base.sort;

import com.zhen777.base.Util;

/**
 * 插入排序
 *
 * @author zhang
 * @date 2023/02/22
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = Util.makeNoRepeatArray(50, 20);
        Util.printArray(arr);
        insertSort2(arr);
        Util.printArray(arr);
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int k = i; k > 0; k--) {
                if (arr[k] < arr[k - 1]) {
                    Util.swapArray(arr, k, k - 1);
                }
            }
        }
    }

    private static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int end = i;
            while (end > 0 && (arr[end] < arr[end - 1])) {
                Util.swapArray(arr, end, end - 1);
                end--;
            }
        }
    }

    private static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int k = i; k > 0 && (arr[k] < arr[k - 1]); k--) {
                Util.swapArray(arr, k, k - 1);
            }
        }
    }
}
