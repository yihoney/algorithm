import java.io.*;

public class Solution {

    static int N;
    static int[][] arr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            sb.append("#").append(tc).append("\n");
            solution(0, -1, 2, 1);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void solution(int x, int y, int dir, int cnt) {

        if (cnt == N * N + 1) {
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
            if (dir == 0) {
                dir = 3;
            } else {
                dir -= 1;
            }
            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        arr[nx][ny] = cnt;

        solution(nx, ny, dir, cnt + 1);
    }

}
