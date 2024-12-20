package _0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];

        int input = Integer.parseInt(br.readLine());
        while (input > 0) {
            numbers[input % 10]++;
            input /= 10;
        }

        int maxNumber = 0;
        // 나누기 연산할 때는 버림에 대한 처리를 고려하자!
        int count = (numbers[6] + numbers[9] + 1) / 2;
        for (int i = 0; i < numbers.length; i++) {
            if (i != 6 && i != 9) {
                maxNumber = Math.max(maxNumber, numbers[i]);
            }
        }

        maxNumber = Math.max(maxNumber, count);

        System.out.println(maxNumber);

    }
}
