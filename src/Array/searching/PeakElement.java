package Array.searching;

import Array.rearrangement.CommonUtil;

public class PeakElement {
    public static int peakElement(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == high || arr[mid] > arr[mid + 1])) {
                return mid;
            } else if (mid + 1 <= high && arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int peakElementRecursive(int[] arr, int h, int l) {
        if (h < l) return arr[0];
        int mid = (h + l) / 2;
        if ((mid==0 || arr[mid] > arr[mid - 1]) && (mid==h || arr[mid] > arr[mid + 1])) return mid;
        else if (mid<h && arr[mid + 1] > arr[mid]) return peakElementRecursive(arr, h, mid + 1);
        return peakElementRecursive(arr, mid - 1, l);

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int x = 0;
        CommonUtil.printValue("Peak " + peakElementRecursive(arr, arr.length - 1, 0));
        CommonUtil.printValue("Peak " + peakElement(arr));


    }



}
