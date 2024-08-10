package Array.searching;

import Array.rearrangement.CommonUtil;

public class CeilAndFloorBinarySearch {


    public static int ceilBinarySearch(int[] arr, int key) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if ((mid == 0 || arr[mid - 1] < key) && key <= arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }


    public static int ceilBinarySearchRecursive(int[] arr, int key, int h, int l) {
        if (h < l) return -1;
        if (key < arr[l]) {
            return 0;
        }
        if (key > arr[h]) {
            return -1;
        }
        int mid = (h + l) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] < key) {
            if (mid + 1 < h && arr[mid + 1] < key) {
                return mid;
            }
            return ceilBinarySearchRecursive(arr, key, mid - 1, l);
        } else {
            if (arr[mid + 1] > key) {
                return mid;
            }
            return ceilBinarySearchRecursive(arr, key, h, mid + 1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 0;
        CommonUtil.printValue("Ceil recursive " + ceilBinarySearchRecursive(arr, x, arr.length - 1, 0));
        CommonUtil.printValue("Ceil " + ceilBinarySearch(arr, x));
        CommonUtil.printValue("floor " + floorBinarySearch(arr, x));
        CommonUtil.printValue("floor recursive " + floorRecursiveBinarySearch(arr, x, arr.length-1,0));

    }

    public static int floorBinarySearch(int[] arr, int key) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if ((mid == arr.length - 1 || arr[mid + 1] > key) && key >= arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }


    public static int floorRecursiveBinarySearch(int[] arr, int key, int h, int l) {
        if (h < l) return -1;
        if (arr[arr.length - 1] <= key) return arr.length - 1;
        if (key < arr[0]) return -1;
        int mid = (h + l) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid]>key){
            if(mid-1>=l && arr[mid-1]<key){
                return mid-1;
            }
            return floorRecursiveBinarySearch(arr,key, mid-1,l);
        }
        else{
            if(arr[mid+1]>key){
                return mid;
            }
            return floorRecursiveBinarySearch(arr,key, h,mid+1);
        }


    }




    public static int ceilBinarySearch1(Integer[] arr, int key) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if ((mid == 0 || arr[mid - 1] < key) && key <= arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    public static int floorBinarySearch1(Integer[] arr, int key) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if ((mid == arr.length - 1 || arr[mid + 1] > key) && key >= arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

}
