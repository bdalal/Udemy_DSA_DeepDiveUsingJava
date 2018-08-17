package deepdive.sorting.challenges;

public class SortChallenge3 {

    public static void main(String[] args) {
        String[] arr = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        int width = 5;
        int radix = 26;

        for (int i = 0; i < width; i++) {
            char[] alphabetArray = getAlphabetArray(arr, i);
            int[] countingArray = getCountingArray(alphabetArray, radix);
            adjustCountingArray(countingArray);
            String[] temp = stableCountingSort(arr, countingArray, alphabetArray);
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static char[] getAlphabetArray(String[] arr, int pos) {
        char[] alphabetArray = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
            alphabetArray[i] = arr[i].substring(arr.length - 1 - pos, arr.length - pos).toCharArray()[0];
        return alphabetArray;
    }

    private static int[] getCountingArray(char[] arr, int radix) {
        int[] countingArray = new int[radix];
        for (int i = 0; i < arr.length; i++)
            countingArray[arr[i] - 'a']++;
        return countingArray;
    }

    private static void adjustCountingArray(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
    }

    private static String[] stableCountingSort(String[] arr, int[] countingArray, char[] alphabetArray) {
        String[] temp = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            temp[--countingArray[alphabetArray[i] - 'a']] = arr[i];
        return temp;
    }

}