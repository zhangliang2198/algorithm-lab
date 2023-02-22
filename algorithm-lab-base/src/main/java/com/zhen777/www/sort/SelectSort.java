package com.zhen777.www.sort;

import com.zhen777.www.Util;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = Util.makeNoRepeatArray(50, 20);
        Util.printArray(arr);
        selectSort(arr);
        Util.printArray(arr);
    }

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;

        // 总共比对len - 1就行
        for (int i = 0; i < len - 1; i++) {
            int maxIndex = i;
            // 第1次 0 ~ len-1 找最大
            // 第2次 1 ~ len-1 找最大
            // 第 len-1 次 len-2 ~ len-1 找最大
            for (int j = i + 1; j < len; j++) {
                // if (arr[j] > arr[maxIndex]) {
                //     maxIndex = j;
                // }
                maxIndex = (arr[j] > arr[maxIndex]) ? j : maxIndex;
            }
            Util.swapArray(arr, maxIndex, i);
        }
    }
}
