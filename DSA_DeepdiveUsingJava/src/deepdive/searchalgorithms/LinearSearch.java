package deepdive.searchalgorithms;

import deepdive.sorting.constants.Constants;

public class LinearSearch {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.NORMAL);
        int inp = 1;
        boolean found = false;

        for (int x : arr)
            if (x == inp) {
                found = true;
                break;
            }
        if (found)
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
}
