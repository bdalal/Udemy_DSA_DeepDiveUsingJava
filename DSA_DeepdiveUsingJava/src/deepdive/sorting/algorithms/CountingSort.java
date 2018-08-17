package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

import java.util.Arrays;

public class CountingSort {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.POS_DISCRETE);
        fill(arr, count(arr, 1, 10), 1);
        Constants.printArr(arr);
    }

    public static int[] count(int[] arr, int min, int max) {
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++)
            countArr[arr[i] - min]++;
        return countArr;
    }

    private static void fill(int[] arr, int[] countArr, int min) {
        int ctr = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                Arrays.fill(arr, ctr, ctr + countArr[i], i + min);
                ctr += countArr[i];
            }
        }
    }
}
