package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

public class SelectionSort {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.NORMAL);

        for (int i = 0; i < arr.length; i++) {
            int largest = 0;
            for (int j = 1; j < arr.length - i; j++)
                if (arr[largest] < arr[j])
                    largest = j;
            Constants.swap(arr, largest, arr.length - i - 1);
        }

        Constants.printArr(arr);
    }
}
