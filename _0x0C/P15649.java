package _0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {

    static int[] arr;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
