package deepdive.sorting.constants;

public class Constants {
    private static final int[] ARRAY = {20, 35, -15, 7, 55, 1, -22, 0, 9, -33};
    private static final int[] POSITIVE_DISCRETE_ARRAY = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
    private static final int[] RADIX_ARRAY = {4725, 4586, 1330, 8792, 1594, 5729};

    public static final String NORMAL = "n";
    public static final String POS_DISCRETE = "p";
    public static final String RADIX = "r";

    public static int[] getArray(String array_type) {
        if (array_type.equals(NORMAL))
            return ARRAY.clone();
        if (array_type.equals(POS_DISCRETE))
            return POSITIVE_DISCRETE_ARRAY.clone();
        if (array_type.equals(RADIX))
            return RADIX_ARRAY.clone();
        else
            throw new IllegalArgumentException("Specify array type");
    }

    public static void swap(int[] arr, int x, int y) {
        if (x == y)
            return;
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }

}
