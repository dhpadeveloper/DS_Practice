package Array.searching;

public class LongestIncreasingSubsequence {


    public static int longestIncreasingSubsequence(int[] arr) {

        int maxIndex = 0;
        int len = 1;
        int max = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                if (len > max) {
                    max = len;
                    maxIndex = i - max;
                }
                len = 1;
            }

        }
        if (len > max) {
            max = len;
            maxIndex = arr.length - max;
        }
        System.out.println("start " + maxIndex + " end " + (max + maxIndex - 1));
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-5, 1, 5, 0, -7};
        System.out.println(longestIncreasingSubsequence(arr));

        int[] arr1 = {52, -91, 70};
        System.out.println(largestAltitude(arr1));
    }


    public static int largestAltitude(int[] gain) {
        int max = gain[0] > 0 ? gain[0] : 0;
        int sum = gain[0];
        for (int i = 1; i < gain.length; i++) {
            sum = sum + gain[i];
            max = Math.max(sum, max);
        }

        return max < 0 ? 0 : max;
    }


}
