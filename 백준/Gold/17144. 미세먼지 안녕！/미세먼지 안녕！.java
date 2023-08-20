import java.io.*;
import java.util.*;

/**
 * BJ 17144 미세먼지 안녕!
 * 
 * [미세먼지 확산]
 * - 인접한 네 방향으로 확산 (공기청정기가 있거나 칸이 없는 곳은 예외)
 * - 확산되는 양은 미세먼지 양의 1/5 (소수점 버림)이고, 남은 미세먼지의 양은 기존의 미세먼지 양에서 확산된 양을 빼준 만큼
 * 
 * [공기청정기 작동]
 * - 위쪽 공기청정기의 바람은 반시계방향으로, 아래쪽 공기청정기의 바람은 시계방향으로 순환
 * - 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
 * - 공기청정기로 들어간 미세먼지는 모두 정화됨
 * 
 * @author 이하늬
 */

public class Main {
    static int arr[][], arr2[][], air[][];
    static int[][] rightDir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 시계방향(우, 하, 좌, 상)
    static int[][] leftDir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }; // 반시계방향(우, 상, 좌, 하)
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 격자판의 행
        C = Integer.parseInt(st.nextToken()); // 격자판의 열
        int T = Integer.parseInt(st.nextToken()); // 방에 남아있는 미세먼지의 양을 구할 시간 T초

        air = new int[2][2];
        int cnt = 0;
        arr = new int[R + 2][C + 2]; // 테두리 패딩
        arr2 = new int[R + 2][C + 2]; // 확산된 미세먼지 양을 저장할 배열
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -2);
            Arrays.fill(arr2[i], -2);
        }
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr2[i][j] = arr[i][j];
                if (arr[i][j] == -1) {
                    air[cnt][0] = i;
                    air[cnt++][1] = j;
                }
            }
        }

        for (int t = 1; t <= T; t++) {
            solution(); // 해당 메서드는 1초동안 동작하는 과정이므로 T초만큼 반복
        }

        // System.out.println("-----------------------");
        // for (int i = 1; i <= R; i++) {
        // for (int j = 1; j <= C; j++) {
        // System.out.print(arr2[i][j] + " ");
        // }
        // System.out.println();
        // }
        int ans = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (arr2[i][j] > 0) {
                    ans += arr2[i][j];
                }
            }
        }

        System.out.println(ans);

    }

    /**
     * 1초동안 미세먼지 확산과 공기청정기가 작동하는 과정
     */
    public static void solution() {

        // 1. 미세먼지 확산

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                int cx = i; // 현재 row
                int cy = j; // 현재 col

                if (arr[i][j] == -1 || arr[i][j] == 0) { // 공기청정기이거나 확산될 양이 없다면 확산 과정 스킵
                    continue;
                }

                int amount = arr[i][j] / 5; // 확산되는 양은 1/5
                for (int d = 0; d < rightDir.length; d++) {
                    // 확산될 위치 계산
                    int nx = cx + rightDir[d][0];
                    int ny = cy + rightDir[d][1];

                    if (arr[nx][ny] == -2 || arr[nx][ny] == -1) { // 배열 범위를 벗어나거나 공기청정기가 있다면
                        continue; // 다른 확산 방향 탐색
                    }

                    arr2[nx][ny] += amount; // 확산될 위치에는 확산되는 양 더해주고
                    arr2[cx][cy] -= amount; // 기존의 위치에는 확산된 만큼 빼주기
                }
            }
        }

        // 2. 공기청정기 돌리기

        // 반시계방향 시작점은 위쪽 공기청정기 좌표
        int cx = air[0][0];
        int cy = air[0][1] + 1;
        int data = arr2[cx][cy];
        arr2[cx][cy] = 0;
        int d = 0;

        // 위쪽 반시계방향 순환 , 방향벡터 (우, 상, 좌, 하)
        while (true) {
            int nx = cx + leftDir[d][0];
            int ny = cy + leftDir[d][1];

            if (arr2[nx][ny] == -2) { // 배열 범위를 벗어나면
                d++;
                nx = cx + leftDir[d][0];
                ny = cy + leftDir[d][1];
            }

            // System.out.println(nx + "," + ny + ": " + data);

            if (nx == air[0][0] && ny == air[0][1]) { // 시작점으로(공기청정기가 있는 곳) 돌아오면 반복문 탈출
                break; // 미세먼지 흡수 및 종료
            }

            int tmp = arr2[nx][ny];
            arr2[nx][ny] = data; // 미세먼지 옮기기
            data = tmp;
            cx = nx;
            cy = ny;
        }

        // 아래쪽 시계방향 순환 , 방향벡터 (우, 하, 좌, 상)
        cx = air[1][0];
        cy = air[1][1] + 1;
        data = arr2[cx][cy];
        arr2[cx][cy] = 0;
        d = 0;
        while (true) {
            int nx = cx + rightDir[d][0];
            int ny = cy + rightDir[d][1];

            if (arr2[nx][ny] == -2) { // 배열 범위를 벗어나면
                d++;
                nx = cx + rightDir[d][0];
                ny = cy + rightDir[d][1];
            }

            if (nx == air[1][0] && ny == air[1][1]) { // 시작점으로(공기청정기가 있는 곳) 돌아오면 반복문 탈출
                break; // 미세먼지 흡수 및 종료
            }

            int tmp = arr2[nx][ny];
            arr2[nx][ny] = data; // 미세먼지 옮기기
            data = tmp;
            cx = nx;
            cy = ny;
        }

        for (int i = 0; i < arr2.length; i++) {
            arr[i] = Arrays.copyOf(arr2[i], arr2[i].length);
        }
    }

}