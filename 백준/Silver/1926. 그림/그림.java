import java.util.*;
import java.io.*;

/**
 * BJ 1926 그림
 * 
 * 그림이라는 것은 1로 연결된 것 -> 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림 4방 탐색을 하며
 * BFS로 해결
 */

public class Main {
	static int[][] arr;
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상,좌,하,우
	static int ans;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N + 2][M + 2];
		isVisited = new boolean[N + 2][M + 2];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MIN_VALUE; // 최소 1번은 바뀌어야되므로 최댓값 저
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!isVisited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		if (cnt == 0) { // 그림이 하나도 없는 경우 
			ans = 0;
		}
		System.out.println(ans);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		isVisited[x][y] = true;

		int size = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int d = 0; d < dirs.length; d++) {
				int nx = cx + dirs[d][0];
				int ny = cy + dirs[d][1];

				if (!isVisited[nx][ny] && arr[nx][ny] == 1) {
					queue.offer(new int[] { nx, ny });
					isVisited[nx][ny] = true;
					size++;
				}
			}
		}

		ans = Math.max(ans, size);

	}

}
