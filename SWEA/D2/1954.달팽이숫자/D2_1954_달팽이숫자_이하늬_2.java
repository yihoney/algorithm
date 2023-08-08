package swea.D2.D2_1954_달팽이숫자;

import java.io.*;

/**
 * <pre>
 * 			dx, dy 적용 -> 0: 서(0,-1), 1: 남(1,0), 2: 동(0,1), 3: 북(-1,0)
 *          조건에 맞게 방향값을 변경하여 이동할 위치를 계산해준 후 재귀 함수 호출!
 *          - 기저 조건: 호출 횟수(cnt)가 N*N을 넘어서면 종료
 * 
 *          메모리: 18,324KB, 실행시간: 100ms 
 * 
 *          @author 이하늬
 * 
 * </pre>
 */

public class D2_1954_달팽이숫자_이하늬_2 {

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
            solution(0, -1, 2, 1); // (0,-1)에서 시작, 동으로 가야하니 dir=2
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

        if (cnt == N * N + 1) { // 기저 조건: cnt가 N*N을 넘어서는 경우 종료
            return;
        }

        // 방향 값에 맞게 원래 위치에서 이동할 위치 계산
        int nx = x + dx[dir]; // 원래 위치 + dx[방향값]
        int ny = y + dy[dir]; // 원래 위치 + dy[방향값]

        // 이동할 좌표가 0보다 작거나 N 이상이거나 이미 값이 채워져있는 경우 방향값 변경
        if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
            if (dir == 0) { // 서쪽으로 가고 있었다면
                dir = 3; // 북쪽으로 변경
            } else { // 서쪽이 아니었다면
                dir -= 1; // 북->동/ 동->남/ 남->서로 변경
            }

            // 변경된 방향값을 적용하여 이동할 위치 다시 계산
            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        // 배열에 숫자 저장
        arr[nx][ny] = cnt;

        // 현재 위치, 방향값, 숫자값+1을 인자로 하여 함수 재호출
        solution(nx, ny, dir, cnt + 1);
    }

}
