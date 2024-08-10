package Array.searching;

import Array.rearrangement.CommonUtil;

public class Equilibrium {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int x = 0;
        CommonUtil.printValue("Peak " + equilibrium(new int[]{-7, 10, -3, 16, 4, 3, 20}));
    }

    public static int equilibrium(int[] arr) {


        int n = arr.length;
        int left = 0, pivot = 0, right = 0;

        // Calculate the right sum
        for (int i = 1; i < n; i++) {
            right += arr[i];
        }

        // Iterate pivot over all the elements of the array
        // and until left != right
        while (pivot < n - 1 && right != left) {
            pivot++;
            right -= arr[pivot];
            left += arr[pivot - 1];
        }

        // If left == right, return pivot as the equilibrium
        // index
        return (left == right) ? pivot + 1 : -1;
    }


}
