package Array.rearrangement;

public class MaximumCircularSubarraySum {

    public static int maximumCircularSubarraySumUsingKadenceTheoram(int[] arr) {
        //Time Complexity: O(N)
        //Auxiliary Space: O(1)
        int max_ending_here = arr[0];
        int min_ending_here = arr[0];
        int max_so_far = arr[0];

        for (int i = 0; i < arr.length; i++) {

            int temp = Math.max(Math.max(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);
            min_ending_here = Math.min(Math.min(arr[i], arr[i] * max_ending_here), arr[i] * min_ending_here);
            max_ending_here = temp;
            max_so_far = Math.max(max_ending_here, max_so_far);

        }
        return max_so_far;

    }

    public static int maximumCircularSubarraySumSimple(int[] arr) {
        // Time Complexity: O(n2)
        // Auxiliary Space: O(1)
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
        }
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            int j = i + 1;
            while (j < i + n) {
                ans = Math.max(ans, sum);
                sum += arr[(j++ % n)];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] array1 = new int[]{-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println(maximumCircularSubarraySumSimple(array1));
        System.out.println(maximumCircularSubarraySumUsingKadenceTheoram(array1));
    }
}

