package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 시작점이 도착점과 같은 경우
        if (S == G) {
            System.out.println(0);
            return;
        }

        int[] map = new int[F + 1];
        map[S] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        boolean isArrived = false;
        int count = 0;

        while (!queue.isEmpty() && !isArrived) {
            int currentStair = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nx = currentStair;
                if (i == 0) {
                    nx += U;
                } else {
                    nx -= D;
                }

                if (nx == G) {
                    isArrived = true;
                    count = map[currentStair] + 1;
                    break;
                }

                if (nx < 1 || nx >= F + 1) continue;

                if (map[nx] == 0) {
                    queue.offer(nx);
                    map[nx] = map[currentStair] + 1;
                }
            }
        }

        if (isArrived) {
            System.out.println(count - 1);
        } else {
            System.out.println("use the stairs");
        }
    }
}
