package com.zhen777.www;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public static void printArray(int[] doubleArray) {
        StringBuilder str = new StringBuilder("[");
        for (int n : doubleArray) {
            str.append(n);
            str.append(",");
        }
        String substring = str.substring(0, str.length() - 1);
        System.out.print(substring + "]");
        System.out.println();
    }

    public static void swapArray1(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void swapArray(int[] array, int i, int j) {
        array[i] =  array[i] ^ array[j];
        array[j] =  array[i] ^ array[j];
        array[i] =  array[i] ^ array[j];
    }
    public static int[] makeArray(int max, int length) {
        Random res = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = res.nextInt(max);
            while (result[i] == 0) {
                result[i] = res.nextInt(max);
            }
        }
        return result;
    }
    public static int[] makeNoRepeatArray(int max, int length) {
        Random res = new Random();
        List<Integer> check = new ArrayList<>(64);

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = res.nextInt(max);
            while (check.contains(result[i])) {
                result[i] = res.nextInt(max);
            }
            check.add(result[i]);
        }
        return result;
    }
}
