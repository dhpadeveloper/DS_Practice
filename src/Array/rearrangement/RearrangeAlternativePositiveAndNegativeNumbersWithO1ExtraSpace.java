package Array.rearrangement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class RearrangeAlternativePositiveAndNegativeNumbersWithO1ExtraSpace {

    static int[] rotateSubArray(int[] arr, int l, int r) {
        int temp = arr[r];
        for (int j = r; j > l ; j--) {
            arr[j] = arr[j - 1];
        }
        arr[l] = temp;

        return arr;
    }

    static int[] moveNegative(int[] arr) {

        int last_negative_index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                last_negative_index += 1;
                int temp = arr[i];
                arr[i] = arr[last_negative_index];
                arr[last_negative_index] = temp;

                // Done to manage order too
                if (i - last_negative_index >= 2)
                    rotateSubArray(arr, last_negative_index + 1, i);
            }
        }


        for (int i = 0, j = last_negative_index + 1; i < arr.length && j < arr.length; i += 2, j++) {
            if (arr[i] < 0) {
                rotateSubArray(arr,i, j);
            }
        }

        return arr;

    }


    public static void main(String[] args) throws Exception {
        int[] arr1 = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] arr2 = {5, 5, -3, 4, -8, 0, -7,
                3, -9, -3, 9, -2, 1};
        int[] arr3 = {-1, -2, -3, -4, -5, -6, -7, 8, 9};
        long startTime = System.currentTimeMillis();

        String[] tokens = new String[0];
        try {
            Scanner scanner = new Scanner(new File("C:\\harsh\\input.txt"));
            while (scanner.hasNextLine())       // change this
            {
                tokens = scanner.nextLine().split(",");
                System.out.println(tokens.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] arr4 = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
         arr1 = moveNegative(arr2);
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println(elapsedTime);
        CommonUtil.printArray(arr1);

        arr2= new int[]{5, 5, -3, 4, -8, 0, -7,
                3, -9, -3, 9, -2, 1};
        betterSolution(arr2);
        CommonUtil.printArray(arr2);


    }


    public static void betterSolution(int[] arr) {
        int outOfPlace = -1;
        for (int i = 0; i < arr.length; i++) {
            if (outOfPlace >= 0) {
                if ((arr[i] >= 0 && arr[outOfPlace] < 0) || (arr[i] < 0 && arr[outOfPlace] >= 0)) {
                    rotateSubArray(arr,outOfPlace,i);

                    if (i - outOfPlace >= 2) {
                        outOfPlace += 2;
                    } else {
                        outOfPlace = -1;
                    }
                }

            } else if (outOfPlace < 0) {
                if ((i % 2 == 0 && arr[i] >= 0) || (i % 2 != 0 && arr[i] < 0)) {
                    outOfPlace = i;
                }
            }

        }


    }

}




