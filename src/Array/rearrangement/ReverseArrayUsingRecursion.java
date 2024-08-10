package Array.rearrangement;

public class ReverseArrayUsingRecursion {

    public static void reverseArrayUsingRecursion(int[] arr){
        reverseArrayUsingRecursion(arr, 0, arr.length-1);
    }
    public static void reverseArrayUsingRecursion(int[] arr, int i ,int j){
        if(i>=j){
            return ;
        }
        int val= arr[i];
        arr[i]=arr[j];
        arr[j]=val;
        reverseArrayUsingRecursion(arr, ++i,--j);
    }

    public static void main(String[] args) {
        int[] oddArray = new int[]{1,2,3,4,5,6,7,8,9};
        int[] evenArray = new int[]{1,2,3,4,5,6,7,8};
        reverseArrayUsingRecursion(oddArray);
        reverseArrayUsingRecursion(evenArray);
        CommonUtil.printArray(oddArray);
        CommonUtil.printArray(evenArray);
    }
}
