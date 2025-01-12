package _0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4779 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int len = (int) Math.pow(3, n);
            char[] arr = new char[len];
            Arrays.fill(arr, '-');

            recursion(0, len, arr);

            for (int i = 0; i < len; i++) {
                sb.append(arr[i]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();

    }

    static void recursion(int start, int length, char[] arr) {
        if (length == 1) return;

        int division = length / 3;

        for (int i = start + division; i < start + 2 * division; i++) {
            arr[i] = ' ';
        }

        recursion(start, division, arr);
        recursion(start + 2 * division, division, arr);
    }
}
