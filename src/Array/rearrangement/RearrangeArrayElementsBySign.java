package Array.rearrangement;

public class RearrangeArrayElementsBySign {

    public static void rearrangeArrayElementsBySign(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {

            if (i % 2 == 0 && arr[i] < 0) {
                if (arr[j] >= 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j = arr.length - 1;
                    i++;
                } else {
                    j--;
                }
            }
            if (i % 2 != 0 && arr[i] >= 0) {
                if (arr[j] % 2 < 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j = arr.length - 1;
                    i++;
                } else {
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int[] array2 = new int[]{-1, 3, -2, -4, 7, -5};
        rearrangeArrayElementsBySign(array1);
        rearrangeArrayElementsBySign(array2);
        CommonUtil.printArray(array1);
        CommonUtil.printArray(array2);
    }
}
