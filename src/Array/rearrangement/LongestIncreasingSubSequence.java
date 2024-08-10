package Array.rearrangement;

import Array.searching.CeilAndFloorBinarySearch;

import java.util.*;
import java.util.Stack;

public class LongestIncreasingSubSequence {
    static int lengthOfLIS(int[] nums) {
        // Binary search approach
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Initialize the answer list with the
        // first element of nums
        ans.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                // If the current number is greater
                // than the last element of the answer
                // list, it means we have found a
                // longer increasing subsequence.
                // Hence, we append the current number
                // to the answer list.
                ans.add(nums[i]);
            } else {
                // If the current number is not
                // greater than the last element of
                // the answer list, we perform
                // a binary search to find the smallest
                // element in the answer list that
                // is greater than or equal to the
                // current number.

                // The binarySearch method returns
                // the index of the first element that is not less than
                // the current number.

             //   int low = Collections.binarySearch(ans, nums[i]);
                int low = CeilAndFloorBinarySearch.ceilBinarySearch1(ans.toArray(new Integer[0]), nums[i]);

                // We update the element at the
                // found position with the current number.
                // By doing this, we are maintaining
                // a sorted order in the answer list.
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, nums[i]);
            }
        }

        // The size of the answer list
        // represents the length of the
        // longest increasing subsequence.
        return ans.size();
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] nums = {15,14, 22, 9, 33, 6,7,8,21, 50, 41, 60};
        // Function call
        System.out.println("Length of LIS is " + lengthOfLIS(nums));
    }

}




