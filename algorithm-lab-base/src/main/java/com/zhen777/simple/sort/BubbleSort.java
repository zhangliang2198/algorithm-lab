package com.zhen777.simple.sort;

import com.zhen777.simple.Util;

/**
 * 冒泡排序
 *
 * @author zhang
 * @date 2023/02/22
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = Util.makeNoRepeatArray(50, 20);
        Util.printArray(arr);
        bubbleSort(arr);
        Util.printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Util.swapArray(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;

        for (int i = length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[j - 1]) {
                    Util.swapArray(arr, j, j - 1);
                }
            }
        }
    }
}
