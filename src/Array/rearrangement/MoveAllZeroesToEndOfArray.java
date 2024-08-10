package Array.rearrangement;

public class MoveAllZeroesToEndOfArray {

    public static void moveAllZeroesToEndOfArray(int[] arr) {
        int i = 0, j = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == 0 && arr[j] != 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
            } else if (arr[i] != 0) {
                i++;
            }
            j++;

        }
    }

    public static void moveAllZeroesToEndOfArrayTimeOptimized(int[] arr) {
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[count++]=arr[i];
            }
        }

        while (count < arr.length)
            arr[count++] = 0;
    }




    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        int[] array2 = new int[]{1, 2, 0, 0, 0, 3, 6};
        moveAllZeroesToEndOfArray(array1);
        moveAllZeroesToEndOfArray(array2);
        CommonUtil.printArray(array1);
        CommonUtil.printArray(array2);
    }
}
