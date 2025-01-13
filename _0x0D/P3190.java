package _0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3190 {

    static class Command {
        int count;
        char direction;

        public Command(int count, char direction) {
            this.count = count;
            this.direction = direction;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1]; // 0행과 0열은 사용하지 않음

        int appleCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int commandCount = Integer.parseInt(br.readLine());
        Queue<Command> commandQueue = new LinkedList<>();
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            char direction =  st.nextToken().charAt(0);
            commandQueue.offer(new Command(count, direction));
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{1, 1});

        int time = 0;
        int currentDirection = 0;
        Command nextCommand = commandQueue.poll();

        while (true) {
            time++;

            int[] head = snake.peekFirst();
            int nx = head[0] + dx[currentDirection];
            int ny = head[1] + dy[currentDirection];

            if (nx < 1 || nx > N || ny < 1 || ny > N || checkCollision(snake, nx, ny)) {
                break;
            }

            snake.addFirst(new int[]{nx, ny});

            if (map[nx][ny] != 1) {
                snake.removeLast();
            } else {
                map[nx][ny] = 0;
            }

            if (nextCommand != null && time == nextCommand.count) {
                currentDirection = changeDirection(currentDirection, nextCommand.direction);
                nextCommand = commandQueue.poll();
            }
        }


        System.out.println(time);
    }

    private static int changeDirection(int current, char cmd) {
        if(cmd == 'D') { // 오른쪽 90도
            return (current + 1) % 4;
        }
        return (current + 3) % 4; // 왼쪽 90도
    }

    private static boolean checkCollision(Queue<int[]> snake, int x, int y) {
        for (int[] pos : snake) {
            if (pos[0] == x && pos[1] == y) {
                return true;
            }
        }
        return false;
    }
}
