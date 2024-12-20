package _0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];

        int target = 1;
        for (int i = 0; i < 3; i++) {
            target *= Integer.parseInt(br.readLine());
        }

        while (target > 0) {
            int result = target % 10;
            numbers[result]++;
            target /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(numbers[i]);
        }
    }
}
