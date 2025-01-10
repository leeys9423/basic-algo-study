package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[][] fireMap;
    static char[][] map;
    static int r, c;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        fireMap = new int[r][c];
        Queue<Point> fireQueue = new LinkedList<>();
        Point jihoon = null;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                fireMap[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j, 0));
                    fireMap[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jihoon = new Point(i, j, 0);
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Point cur = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (map[nx][ny] != '#' && fireMap[nx][ny] == Integer.MAX_VALUE) {
                    fireMap[nx][ny] = cur.time + 1;
                    fireQueue.offer(new Point(nx, ny, cur.time + 1));
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        queue.offer(jihoon);
        visited[jihoon.x][jihoon.y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == 0 || cur.x == r - 1 || cur.y == 0 || cur.y == c - 1) {
                System.out.println(cur.time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] != '#' && cur.time + 1 < fireMap[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, cur.time + 1));
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}
