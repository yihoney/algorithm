import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static boolean[][] map;
	static boolean[][] visited;
	static int R, C, K;
	static int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				if (str.charAt(c) == '.') {
					map[r][c] = true;
				}
			}
		}
		visited[R - 1][0] = true;
		solution(R - 1, 0, 1);
		System.out.println(ans);
	}

	public static void solution(int r, int c, int cnt) {

		if (r == 0 && c == C - 1) {
			if (cnt == K) {
				ans++;
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			if (isValid(nr, nc) && !visited[nr][nc] && map[nr][nc]) {
				visited[nr][nc] = true;
				solution(nr, nc, cnt + 1);
				visited[nr][nc] = false;
			}
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}