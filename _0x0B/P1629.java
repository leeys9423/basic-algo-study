package _0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recursive(a, b, c));
    }

    static int recursive(int a, int b, int c) {
        if (b == 1) return a % c;
        int rest = recursive(a, b / 2, c);
        rest = rest * rest % c;
        if (b % 2 == 0) return rest;
        return rest * a % c;
    }
}
