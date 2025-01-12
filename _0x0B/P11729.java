package _0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int n, int start, int mid, int to) {
        count++;

        // 기저 조건: 원판이 1개일 때
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        // step 1: n-1개를 중간 기둥으로 이동
        hanoi(n - 1, start, to, mid);

        // step 2: 가장 큰 원판을 목적지로 이동
        sb.append(start + " " + to + "\n");

        // step 3: n-1개를 목적지로 이동
        hanoi(n - 1, mid, start, to);
    }
}
