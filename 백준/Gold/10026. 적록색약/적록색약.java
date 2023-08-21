import java.io.*;

public class Main {
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int ans1 = 0, ans2 = 0;
	static char[][] arr1, arr2; // 정상인과 적록색약
	static boolean[][] isVisited1, isVisited2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		isVisited1 = new boolean[N + 2][N + 2];
		isVisited2 = new boolean[N + 2][N + 2];
		arr1 = new char[N + 2][N + 2];
		arr2 = new char[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				arr1[i][j] = str.charAt(j-1);
				if (str.charAt(j-1) == 'G') {
					arr2[i][j] = 'R';
				} else {
					arr2[i][j] = str.charAt(j-1);
				}
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (!isVisited1[r][c]) {
					dfs(isVisited1, arr1, r, c);
					ans1++;
				}
				if (!isVisited2[r][c]) {
					dfs(isVisited2, arr2, r, c);
					ans2++;
				}
			}
		}

		System.out.println(ans1 + " " + ans2);

	}

	public static void dfs(boolean[][] isVisited, char[][] arr, int cx, int cy) {

		isVisited[cx][cy] = true;
		int nx, ny;
		for (int d = 0; d < dirs.length; d++) {
			nx = cx + dirs[d][0];
			ny = cy + dirs[d][1];

			if (arr[nx][ny] != 0 && !isVisited[nx][ny] && (arr[cx][cy] == arr[nx][ny])) {
				isVisited[nx][ny] = true;
				dfs(isVisited, arr, nx, ny);
			}
		}

	}

}