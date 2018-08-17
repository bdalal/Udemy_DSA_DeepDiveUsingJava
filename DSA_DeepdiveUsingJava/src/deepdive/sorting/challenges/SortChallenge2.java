package deepdive.sorting.challenges;

import deepdive.sorting.constants.Constants;

public class SortChallenge2 {
    public static void main(String[] args) {
        int[] intArray = Constants.getArray(Constants.NORMAL);

        insertionSort(intArray, intArray[1], 1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void insertionSort(int[] arr, int current, int i) {
        arr[move(arr, current, i)] = current;
        if (i == arr.length - 1)
            return;
        current = arr[++i];
        insertionSort(arr, current, i);
    }

    private static int move(int[] arr, int current, int i) {
        if (i < 1 || current >= arr[i - 1])
            return i;
        arr[i] = arr[i - 1];
        return move(arr, current, --i);
    }

}
