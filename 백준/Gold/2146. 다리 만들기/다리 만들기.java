import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N, ans = Integer.MAX_VALUE, n = 1;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					markIsland(r, c);
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0 && isStartPoint(r, c)) {
					bfs(r, c);
				}
			}
		}

		
		System.out.println(ans);
	}

	private static boolean isStartPoint(int r, int c) {
		int cnt = 0;

		for (int d = 0; d < dirs.length; d++) {
			int nx = r + dirs[d][0];
			int ny = c + dirs[d][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (map[nx][ny] != 0) {
				cnt++;
			}
		}

		if (cnt == 0) {
			return false;
		}

		return true;
	}

	private static void markIsland(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		boolean visited[][] = new boolean[N][N];
		queue.offer(new int[] { r, c });
		map[r][c] = n;
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int d = 0; d < dirs.length; d++) {
				int nx = cx + dirs[d][0];
				int ny = cy + dirs[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					map[nx][ny] = n;
				}
			}
		}
		n++;
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int visited[][] = new int[N][N];
		queue.offer(new int[] { r, c });
		visited[r][c] = 1;
		int start = findStart(r, c);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int d = 0; d < dirs.length; d++) {
				int nx = cx + dirs[d][0];
				int ny = cy + dirs[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				if (map[nx][ny] != 0 && map[nx][ny] != start) {
					ans = Math.min(ans, visited[cx][cy]);
					
//					if(ans>visited[cx][cy]) {
//					ans = Math.min(ans, visited[cx][cy]);
//						for (int i = 0; i < N; i++) {
//							for (int j = 0; j < N; j++) {
//								System.out.print(visited[i][j] + " ");
//						
//							}
//							System.out.println();
//						}						
//					}
				}

				if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = visited[cx][cy] + 1;
				}
			}
		}

				
	}

	private static int findStart(int r, int c) {
		int start = 0;
		for (int d = 0; d < dirs.length; d++) {
			int nx = r + dirs[d][0];
			int ny = c + dirs[d][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (map[nx][ny] != 0) {
				return map[nx][ny];
			}
		}
		return start;
	}
}