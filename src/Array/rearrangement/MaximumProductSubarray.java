package Array.rearrangement;

public class MaximumProductSubarray {

    public static int maximumProductSubarrayUsingKadenceTheoram(int[] arr) {
       //Time Complexity: O(N)
        //Auxiliary Space: O(1)
        int max_ending_here = arr[0];
        int min_ending_here = arr[0];
        int max_so_far = arr[0];

        for(int i=1;i<arr.length;i++){

            int temp = Math.max(Math.max(arr[i],arr[i]*max_ending_here), arr[i]*min_ending_here);
            min_ending_here = Math.min(Math.min(arr[i],arr[i]*max_ending_here), arr[i]*min_ending_here);
            max_ending_here= temp;
            max_so_far = Math.max(max_ending_here,max_so_far);

        }
        return max_so_far;

    }

    public static int maximumProductSubarraySimple(int[] arr) {
        //Using two iteration only fromleft and fromright
       // Time Complexity: O(N)
        // Auxiliary Space: O(1)
        int leftToRight = 1;
        int rightToLeft = 1;
        int ans = 0;
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            if( leftToRight == 0 ) leftToRight = 1;
            if( rightToLeft == 0 ) rightToLeft = 1;

            leftToRight= leftToRight*arr[i];
            rightToLeft= rightToLeft*arr[n-1-i];
            ans = Math.max(Math.max(leftToRight,rightToLeft),ans);
        }
return ans;

    }




    public static void main(String[] args) {
        int[] array1 = new int[]{2,-2,-3,1,-7,-8,-2,5};
        //1st solution nested loop O(n2)
        System.out.println(maximumProductSubarraySimple(array1));
        System.out.println(maximumProductSubarrayUsingKadenceTheoram(array1));
    }
}
