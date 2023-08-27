import java.util.*;
import java.io.*;

public class Solution {

	static int[][] arr;
	static int N, maxDay, ans;
	static StringBuilder sb = new StringBuilder();
	static boolean flag[][];
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상, 좌, 하, 우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 치즈 한 변의 길

			arr = new int[N + 2][N + 2];
			maxDay = Integer.MIN_VALUE;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(arr[i][j], maxDay);
				}
			}
			ans = 1;

			for (int day = 1; day <= maxDay; day++) {
				int cheeseN = cntCheese(day);
				ans = Math.max(ans, cheeseN);
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}

		System.out.println(sb);

	}

	public static int cntCheese(int day) {
		int cnt = 0;
		flag = new boolean[N + 2][N + 2];

		for (int cx = 1; cx <= N; cx++) {
			for (int cy = 1; cy <= N; cy++) {
				if (flag[cx][cy] || arr[cx][cy] <= day) {
					continue;
				}
				bfs(cx, cy, day);
				cnt++;
			}
		}

		return cnt;
	}

	private static void bfs(int cx, int cy, int day) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { cx, cy });
		flag[cx][cy] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int d = 0; d < dirs.length; d++) {
				int nx = pos[0] + dirs[d][0];
				int ny = pos[1] + dirs[d][1];

				if (arr[nx][ny] == 0 || flag[nx][ny]) {
					continue;
				}
				if (arr[nx][ny] <= day) {
					continue;
				}

				queue.offer(new int[] { nx, ny });
				flag[nx][ny] = true;
			}
		}
	}

}