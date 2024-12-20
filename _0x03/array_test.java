package _0x03;

import java.util.Arrays;

public class array_test {

    public static int[] insert(int idx, int num, int[] arr){
        for (int i = arr.length - 1; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = num;

        return arr;
    }

    public static int[] erase(int idx, int[] arr){
        for (int i = idx; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = 0;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        int[] insert_arr = insert(2, 0, arr);
        System.out.println(Arrays.toString(insert_arr));

        int[] erase_arr = erase(2, arr);
        System.out.println(Arrays.toString(erase_arr));

    }
}
