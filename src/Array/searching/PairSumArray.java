package Array.searching;

import Array.rearrangement.CommonUtil;

import java.util.Arrays;
import java.util.HashSet;

public class PairSumArray {
    public static void main(String[] args) {
        int arr[] = {1, 8, 45, 6, 10, 8, -10, 18, 19, 3, 26};
        int x = 17;
        CommonUtil.printValue("Pair sum " + pairSum(arr, x));
        CommonUtil.printValue("Pair sum " + pairSum2pointer(arr, x));
        printEveryPairSum(arr, x);
        CommonUtil.printValue("triplet sum " + tripletSum(new int[]{1, 3, 4, 20, 6, 12, 45, 19}, 24));

    }

    public static boolean pairSum(int[] arr, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(x - arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

//    public static boolean pairSumBinarySearch(int[] arr, int x) {
    //O(Nlogn)
//        for (int i = 0; i < arr.length; i++) {
//            int searchKey= x-arr[i];
//            if(Collections.binarySearch(arr[i], searchKey)){
//                return true;
//            }
//        }
//        return false;
//    }


    public static boolean pairSum2pointer(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        Arrays.sort(arr);
        while (i < j) {
            if (arr[i] + arr[j] == x) return true;
            else if (arr[i] + arr[j] > x) j--;
            else i++;
        }
        return false;
    }


    public static void printEveryPairSum(int[] arr, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(x - arr[i])) {
                System.out.print(arr[i] + " " + (x - arr[i]));
                System.out.println();
            }
            set.add(arr[i]);
        }
    }

    public static boolean tripletSum(int[] A, int sum) {
        // On2
        int arr_size = A.length;
        for (int i = 0; i < arr_size - 2; i++) {
            HashSet<Integer> s = new HashSet<>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                int required_value = curr_sum - A[j];
                if (s.contains(required_value)) {
                    System.out.println("Triplet is " + A[i]
                            + ", " + A[j] + ", "
                            + required_value);
                    return true;
                }

                s.add(A[j]);
            }
        }

        return false;

    }

}
