package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;

    static class Point {
        int x, y;
        char s;

        public Point(int x, int y, char s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][n];
        int count = 0;
        count = bfs(n, visited, count);

        sb.append(count).append(' ');


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        visited = new boolean[n][n];
        count = 0;
        count = bfs(n, visited, count);
        sb.append(count).append(' ');

        System.out.println(sb.toString());
    }

    private static int bfs(int n, boolean[][] visited, int count) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                Queue<Point> queue = new LinkedList<>();
                queue.offer(new Point(i, j, map[i][j]));
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    Point current = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = current.x + dx[k];
                        int ny = current.y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                        if (!visited[nx][ny] && map[nx][ny] == current.s) {
                            queue.offer(new Point(nx, ny, current.s));
                            visited[nx][ny] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
