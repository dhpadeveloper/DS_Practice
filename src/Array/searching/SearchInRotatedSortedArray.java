package Array.searching;

import Array.rearrangement.CommonUtil;

public class SearchInRotatedSortedArray {

    public static int findPivot(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid + 1;
            } else if (mid == 0 || arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[arr.length - 1] < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;


    }

    public static int findPosition(int[] arr, int high, int low, int key) {
        while (high >= low) {
            int mid = (high + low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static int findTargetPosition(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[pivot] < target && target <= arr[arr.length - 1]) {
            return findPosition(arr, arr.length - 1, pivot, target);
        }
        return findPosition(arr, pivot, 0, target);
    }


    public static void main(String[] args) {
        int[] arr = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 0, 1, 2, 3, 4, 5, 6, 7};
        int target = 6;
        CommonUtil.printValue("target found at = " + findTargetPosition(arr, target));


        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        target = 1;
        CommonUtil.printValue("target found at = " + findTargetPosition(arr2, target));

        int[] arr3 = {5, 6, 7, 1, 2, 3, 4};
        target = 1;
        CommonUtil.printValue("target found at = " + findTargetPosition(arr3, target));




        int[] arr4 = {5, 6, 7, 1, 2, 3, 4};
        target = 3;
        CommonUtil.printValue("target found at = " + findPositionSinglePass(arr3, target));


    }


    public static int findPositionSinglePass(int[] arr, int target) {

        int h = arr.length - 1;
        int l = 0;

        while (h >= l) {
            int mid = (h + l) / 2;
            if (arr[mid] == target) {
                return mid;

            } else if (arr[mid] > arr[l]) {
                if (target >= arr[l] && target < arr[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }


        }
        return -1;

    }


}
