package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;

    static class Point {
        int x, y, z, days;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        map = new int[n][m][h];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                    if (map[j][k][i] == 1) {
                        queue.offer(new Point(j, k, i));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;

                if (map[nx][ny][nz] == 0) {
                    queue.offer(new Point(nx, ny, nz));
                    map[nx][ny][nz] = map[cur.x][cur.y][cur.z] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        max = Math.max(max, map[i][j][k]);
                    }
                }
            }
        }
        System.out.println(max - 1);
    }
}
