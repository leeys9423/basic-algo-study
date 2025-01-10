package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {

    static boolean[] visited;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        int[] distance = new int[visited.length];
        distance[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = cur + 1;
                } else if (i == 1) {
                    next = cur - 1;
                } else {
                    next = 2 * cur;
                }

                if (next == k) {
                    distance[next] = distance[cur] + 1;
                    System.out.println(distance[next]);
                    return;
                }

                if (next >= 0 && next < 100001 && !visited[next]) {
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}
