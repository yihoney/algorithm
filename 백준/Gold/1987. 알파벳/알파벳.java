import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[] isVisited;
	static int R, C, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R + 2][C + 2];
		isVisited = new boolean[26];

		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				arr[i][j] = str.charAt(j - 1);
			}
		}

		ans = Integer.MIN_VALUE;
		dfs(new int[] { 1, 1 }, 0);
		System.out.println(ans);

	}

	public static void dfs(int[] pos, int cnt) {

		int cx = pos[0];
		int cy = pos[1];

		if (isVisited[arr[cx][cy] - 'A']) {

			ans = Math.max(ans, cnt);
			return;

		} else {

			for (int dir = 0; dir < dirs.length; dir++) {

				isVisited[arr[cx][cy] - 'A'] = true;

				int nx = cx + dirs[dir][0];
				int ny = cy + dirs[dir][1];

				if (arr[nx][ny] == 0) {
					continue;
				}

				dfs(new int[] { nx, ny }, cnt + 1);

			}
			isVisited[arr[cx][cy] - 'A'] = false;
		}
	}
}
