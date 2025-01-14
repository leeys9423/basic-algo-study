package _0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {
    static char[][] map;
    static int[][] fireMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fireMap = new int[h][w];
            int sStartX = 0;
            int sStartY = 0;

            Queue<Point> fireQueue = new LinkedList<>();
            for (int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = line.charAt(k);
                    fireMap[j][k] = Integer.MAX_VALUE;  // 초기값을 최대값으로
                    if (map[j][k] == '@') {
                        sStartX = j;
                        sStartY = k;
                        map[j][k] = '.';  // 상근이 위치를 '.'으로 변경
                    } else if (map[j][k] == '*') {
                        fireQueue.offer(new Point(j, k, 0));
                        fireMap[j][k] = 0;
                    } else if (map[j][k] == '#') {
                        fireMap[j][k] = -1;
                    }
                }
            }

            // 불 퍼뜨리기
            while (!fireQueue.isEmpty()) {
                Point currentFire = fireQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = currentFire.x + dx[j];
                    int ny = currentFire.y + dy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#') continue;
                    if (fireMap[nx][ny] > currentFire.time + 1) {  // 더 빠른 시간에 도달할 수 있는 경우만
                        fireQueue.offer(new Point(nx, ny, currentFire.time + 1));
                        fireMap[nx][ny] = currentFire.time + 1;
                    }
                }
            }

            // 상근이 이동
            boolean[][] visited = new boolean[h][w];
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(sStartX, sStartY, 0));  // 시작 시간을 0으로
            visited[sStartX][sStartY] = true;
            boolean escaped = false;

            while (!queue.isEmpty() && !escaped) {
                Point current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(current.time + 1).append('\n');  // 탈출할 때는 1초 추가
                        escaped = true;
                        break;
                    }

                    if (map[nx][ny] == '.' && !visited[nx][ny] &&
                            current.time + 1 < fireMap[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, current.time + 1));
                    }
                }
            }

            if (!escaped) {
                sb.append("IMPOSSIBLE").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
