package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {

    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            Point start = new Point(startX, startY, 0);

            Queue<Point> queue = new LinkedList<>();
            queue.offer(start);
            visited[startX][startY] = true;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                if (cur.x == targetX && cur.y == targetY) {
                    sb.append(cur.count).append('\n');
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;

                    if (!visited[nx][ny]) {
                        queue.offer(new Point(nx, ny, cur.count + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
