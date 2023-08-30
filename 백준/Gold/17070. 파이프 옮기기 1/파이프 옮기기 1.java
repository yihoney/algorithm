import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int[][][] arr = new int[N + 1][N + 1][3]; // 0: 가로, 1: 세로, 2: 대각선

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr[1][2][0] = 1;

		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				// 가로의 경우
				if (j + 1 <= N && map[i][j + 1] == 0) { // 다음 이동 위치에 벽이 없고 배열 범위 안에 있다면
					arr[i][j + 1][0] += arr[i][j][0] + arr[i][j][2]; // 가로 경우 + 대각선의 경우
				}

				// 세로의 경우
				if (i + 1 <= N && map[i + 1][j] == 0) {
					arr[i + 1][j][1] += arr[i][j][1] + arr[i][j][2];
				}

				// 대각선의 경우
				if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
					arr[i + 1][j + 1][2] += arr[i][j][0] + arr[i][j][1] + arr[i][j][2];
				}
			}
		}

		// 가로, 세로, 대각선의 모든 경우의 수 합해서 출력
		System.out.println(arr[N][N][0] + arr[N][N][1] + arr[N][N][2]);
	}

}