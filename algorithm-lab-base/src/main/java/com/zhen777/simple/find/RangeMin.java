package com.zhen777.simple.find;

import com.zhen777.simple.Util;
/**
 * 获取局部最小
 *
 * @author mikoozhang[zhangliang2198@outlook.com]
 * @version 1.0.0
 */
public class RangeMin {
    public static void main(String[] args) {
        int[] arr = new int[]{8,12,3,5,7,3,0,12};
        Util.printArray(arr);
        int index = findRangeMin(arr);
        System.out.println(index);
    }

    private static int findRangeMin(int[] arr) {
        if (arr == null) {
            return -1;
        }
        if (arr.length <= 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid;

        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid - 1] < arr[mid]) {
                R = mid - 1;
            } else if(arr[mid +1] < arr[mid]) {
                L = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
