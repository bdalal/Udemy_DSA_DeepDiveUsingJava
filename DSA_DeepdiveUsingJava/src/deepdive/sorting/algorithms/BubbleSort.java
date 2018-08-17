package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = Constants.getArray(Constants.NORMAL);

        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j < arr.length - i; j++)
                if (arr[j - 1] > arr[j])
                    Constants.swap(arr, j - 1, j);

        Constants.printArr(arr);
    }
}
