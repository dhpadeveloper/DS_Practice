package Array.rearrangement;

import java.util.HashMap;
import java.util.Stack;

public class FindSortedSubsequenceOfSize3InLinearTime {
    static void find3Numbers(int arr[]){
    int n = arr.length;

    // Index of maximum element
    // from right side
    int max = n - 1;

    // Index of minimum element
    // from left side
    int min = 0;
    int i;

    // Create an array that will store
    // index of a smaller element on left side.
    // If there is no smaller element on left
    // side, then smaller[i] will be -1.
    int[] smaller = new int[n];

    // first entry will always be -1
    smaller[0] = -1;
        for (i = 1; i < n; i++) {
        if (arr[i] <= arr[min]) {
            min = i;
            smaller[i] = -1;
        }
        else
            smaller[i] = min;
    }

    // Create another array that will
    // store index of a greater element
    // on right side. If there is no greater
    // element on right side, then greater[i]
    // will be -1.
    int[] greater = new int[n];

    // last entry will always be -1
    greater[n - 1] = -1;
        for (i = n - 2; i >= 0; i--) {
        if (arr[i] >= arr[max]) {
            max = i;
            greater[i] = -1;
        }
        else
            greater[i] = max;
    }

    // Now find a number which has
    // both greater number on right
    // side and smaller number on left side
        for (i = 0; i < n; i++) {
        if (
                smaller[i] != -1 && greater[i] != -1) {
            System.out.print(
                    arr[smaller[i]] + " " + arr[i]
                            + " " + arr[greater[i]]);
            return;
        }
    }

    // If we reach number, then there
    // are no such 3 numbers
        System.out.println("No such triplet found");
        return;
}

public static void main(String[] args)
{
    int arr[] = { 12, 11, 10, 5, 16,6,2,3, 30};
    find3Numbers(arr);
    find3Numbers2(arr);
    find3NumbersIKJ(new int[]{3,1,5,0,4});
}


    public static void find3Numbers2(int[] nums)
    {
        if (nums.length < 3){
            System.out.print("No such triplet found");
            return;
        }
        int seq = 1;
        int min_num = nums[0];

        int max_seq = Integer.MIN_VALUE;

        int store_min = min_num;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == min_num)
                continue;

            else if (nums[i] < min_num)
            {
                min_num = nums[i];
                continue;
            }

            else if (nums[i] < max_seq) {
                max_seq = nums[i];
                store_min = min_num;
            }
            else if (nums[i] > max_seq)
            {seq++;
                if (seq == 3)
                {
                    System.out.println("Triplet: " + store_min +", " + max_seq + ", " + nums[i]);
                    return;
                }
                max_seq = nums[i];
            }
        }
        System.out.print("No such triplet found");
    }






//arr[i]<arr[k]<arr[j]  i,j,k
    public static void find3NumbersIKJ(int[] nums)
    {
        Stack<Integer> stack= new Stack<>();
        int h1 = Integer.MAX_VALUE;
        int h3 = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){

            h1= nums[i];
            while (!stack.isEmpty() && stack.peek()<nums[i]){
                h3 = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
            if(h1<h3){
                System.out.println("Yes");
            }

        }

    }


}




