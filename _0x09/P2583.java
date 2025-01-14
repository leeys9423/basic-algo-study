package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2583 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int M;
    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    visited[j][k] = true;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(count).append('\n');
        Collections.sort(arr);
        for (Integer i : arr) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                if (!visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }

        count++;
        arr.add(size);
    }
}
