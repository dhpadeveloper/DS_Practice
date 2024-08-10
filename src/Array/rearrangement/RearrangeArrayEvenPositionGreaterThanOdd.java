package Array.rearrangement;

public class RearrangeArrayEvenPositionGreaterThanOdd {
    static void swap(int[] arr, int l, int r)
    {
        int temp = arr[l];
       arr[l]= arr[r];
        arr[r] = temp;
    }

    static void rearrangeArrayEvenPositionGreaterThanOdd(int[] arr) {

     for(int i=0;i<arr.length-1;i++){
             if(i%2==0 && arr[i]>arr[i+1]){
                 swap(arr, i, i+1);
             }
             if(i%2!=0 && arr[i]<arr[i+1]){
                 swap(arr, i, i+1);
         }
     }
    }

    public static void main(String[] args) {
        int[] arr1 ={16
                ,18 ,18 ,9, 3 ,16, 18 ,11 ,1 ,13 ,5 ,6, 7, 16, 7, 16, 17};
        int[] arr2 = { 5, 5,  3, 4, 8, 0, 7,
                3, 9, 3, 9, 2, 1 };
        int[] arr3 ={1, 2, 2, 1};
        rearrangeArrayEvenPositionGreaterThanOdd(arr3);
        CommonUtil.printArray(arr3);
    }
}

