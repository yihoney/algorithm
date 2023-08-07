package swea.D2.D2_1954_달팽이숫자;

import java.io.*;

/**
 * <pre>
 * 			크기가 N인 arr[i][j]이 있을 때,
 *          1. i=0은 그대로이고, j=0이  j=N-1이 될 때까지 계속 증가
 *          2. j=N-1은 그대로이고, i=0이 j=N-1이 될 때까지 계속 증가
 *          3. i=N-1은 그대로이고, j=N-1이 j=0이 될 때까지 계속 감소
 *          4. j=0은 그대로이고, i=N-1이 i=0이 될 때까지 계속 감소
 *          를 반복한다.
 * 
 *          @author 이하늬
 * 
 * </pre>
 */

public class D2_1954_달팽이숫자_이하늬_1 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int[][] arr;
    static int N;

    static class Snail {
        public int x, y, count, direction;

        public Snail(int x, int y, int count, int direction) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.direction = direction;
        }

        public void go() {
            this.x = x + dx[direction];
            this.y = y + dy[direction];
            arr[x][y] = count++;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int z = 1; z <= T; z++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            StringBuilder sb = new StringBuilder();
            Snail snail = new Snail(0, -1, 1, 2);

            while (true) {
                int nx = snail.x + dx[snail.direction];
                int ny = snail.y + dy[snail.direction];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
                    if (snail.direction == 0) {
                        snail.direction = 3;
                    } else {
                        snail.direction -= 1;
                    }
                    continue;
                }

                snail.go();
                if (snail.count == N * N + 1) {
                    break;
                }

            }
            sb.append("#" + z + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.print(sb);

        }

    }

}