package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

public class InsertionSort {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.NORMAL);
        insertionSort(arr, 1);
        Constants.printArr(arr);
    }

    public static void insertionSort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int current = arr[i];
            int j;
            for (j = i; j > gap - 1 && current < arr[j - gap]; j = j - gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = current;
        }
    }
}
