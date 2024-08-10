package Array.rearrangement;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayWithEqual0and1 {

    static int maxLen(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hM
                = new HashMap<Integer, Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Initialize result
        int max_len = 0;
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array

        for (int i = 0; i < n; i++) {
            // Add current element to sum

            sum += arr[i];

                // To handle sum=0 at last index

            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
                start_index = 0;
            }

            // If this sum is seen before,
            // then update max_len if required
            if (hM.containsKey(sum)) {
                if (max_len < i - hM.get(sum)) {
                    max_len = i - hM.get(sum);
                    ending_index = i;
                    start_index = hM.get(sum) + 1;
                }
            } else // Else put this sum in hash table
                hM.put(sum, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(start_index + " to " + ending_index);
        return max_len;

    }

    public static void main(String[] args) throws Exception {
        int[] arr1 = {0,0,0,0,1,0,1,0,0};
        System.out.println(maxLen(arr1));


    }

    public int getMaxLength(int[] arr) {
        int maxLength = -1;
        int startIndex = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[i] == 0 ? -1 : 1;
                if (sum == 0 && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        int endindex = startIndex + maxLength - 1;
        if (maxLength == -1)
            System.out.println("No such subarray");
        else
            System.out.println(startIndex + " to " + endindex);
        return maxLength;
    }


}




