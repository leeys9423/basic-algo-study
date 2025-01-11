package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (visited[j][l] || map[j][l] == 0) continue;
                    Queue<Point> queue = new LinkedList<>();
                    Point start = new Point(j, l);
                    queue.offer(start);
                    visited[j][l] = true;

                    while (!queue.isEmpty()) {
                        Point current = queue.poll();

                        for (int o = 0; o < 4; o++) {
                            int nx = current.x + dx[o];
                            int ny = current.y + dy[o];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                            if (!visited[nx][ny] && map[nx][ny] == 1) {
                                queue.offer(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
