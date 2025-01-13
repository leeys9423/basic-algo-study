package _0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503 {

    static class Robot {
        int x, y, direction;

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    // 북, 동, 남, 서 방향 (시계방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int robotX = Integer.parseInt(st.nextToken());
        int robotY = Integer.parseInt(st.nextToken());
        int robotDirection = Integer.parseInt(st.nextToken());

        // 로봇 상태 초기화
        Robot status = new Robot(robotX, robotY, robotDirection);

        // 맵 초기화
        // 0: 북, 3: 서, 2: 남, 1: 동
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 횟수
        int cleanCount = 0;

        while (true) {
            // 현재의 위치가 청소 되어있지 않으면 청소하고 count++
            if (map[status.x][status.y] == 0) {
                map[status.x][status.y] = 2;
                cleanCount++;
            }

            boolean allCleaned = true;
            for (int i = 0; i < 4; i++) {
                int nx = status.x + dx[i];
                int ny = status.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    allCleaned = false;
                    break;
                }
            }

            if (allCleaned) {
                int backDirection = (status.direction + 2) % 4;
                int nx = status.x + dx[backDirection];
                int ny = status.y + dy[backDirection];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 1) {
                    break;
                }

                status.x = nx;
                status.y = ny;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                status.direction = (status.direction + 3) % 4;
                int nx = status.x + dx[status.direction];
                int ny = status.y + dy[status.direction];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    status.x = nx;
                    status.y = ny;
                    break;
                }
            }
        }

        System.out.println(cleanCount);
    }
}
