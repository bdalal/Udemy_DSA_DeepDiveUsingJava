package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

public class ShellSort {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.NORMAL);

        int gap = arr.length / 2;
        while (gap > 0) {
            InsertionSort.insertionSort(arr, gap);
            gap /= 2;
        }

        Constants.printArr(arr);
    }
}
