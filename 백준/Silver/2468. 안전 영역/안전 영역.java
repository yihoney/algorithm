import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static int N, ans;
	static boolean isVisited[][];
	static int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 치즈 한 변의 길

		arr = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 1;
		for (int h = 1; h <= 100; h++) {
			int cnt = cntArea(h);
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}

	public static int cntArea(int h) {
		isVisited = new boolean[N + 2][N + 2];
		int cnt = 0;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (!isVisited[r][c] && arr[r][c] > h) {
					bfs(r, c, h);
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void bfs(int cx, int cy, int h) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { cx, cy });
		isVisited[cx][cy] = true;

		while (!queue.isEmpty()) {
			int[] curPos = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nx = curPos[0] + dirs[d][0];
				int ny = curPos[1] + dirs[d][1];

				if (isVisited[nx][ny] || arr[nx][ny] == 0) {
					continue;
				}

				if (arr[nx][ny] <= h) {
					continue;
				}

				queue.add(new int[] {nx,ny});
				isVisited[nx][ny] = true;
			}
		}

	}
}