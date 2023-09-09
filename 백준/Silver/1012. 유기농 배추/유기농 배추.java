import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ 1012 유기농 배추 
 * - 상하좌우 네 방향에 다른 배추가 위치한 경우 인접한 다른 배추로 배추흰지렁이가 이동할 수 있음
 * - 배추가 심어져 있는 땅(1)이 몇 군데에 퍼져있는지 구하는 문제 -> floodfill 이용 
 */

public class Main {
	static int M,N;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int t = 0; t < T; t++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
			N = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

			map = new int[M][N];
			isVisited = new boolean[M][N];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken()); // 배추 위치 X 
				int Y = Integer.parseInt(st.nextToken()); // 배추 위치 Y 
				map[X][Y] = 1;
			}

			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1 && !isVisited[r][c]) {
						dfs(r,c);
						ans++;
					}
				}
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int r, int c) {

		isVisited[r][c] = true;

		for (int d = 0; d < dirs.length; d++) {

			int nx = r + dirs[d][0];
			int ny = c + dirs[d][1];

			if (isInArray(nx, ny)) {

				if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
					dfs(nx, ny);
				}

			}
		}
	}

	private static boolean isInArray(int r, int c) {
		if (r >= 0 && c >= 0 && M > r && N > c) {
			return true;
		}
		return false;
	}
}