import java.util.*;
import java.io.*;

/**
 * BJ 2667 단지번호
 * 
 * 방문 플래그 배열 생성하여 반복문을 돌며 집이 있는 곳인 1을 만나면 4방 탐색을 수행후 1 만나면 또 4방탐색 하는 것을 반복. ->
 * 4방 탐색하는 이유는 대각선상에 집이 있는 경우는 연결된 것이 아니라 했으므로!
 * 
 * 
 */

public class Main {

	static int[][] map;
	static boolean[][] isVisited;
	static List<Integer> ans;
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 방향벡터 (상,좌,하,우)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 지도의 크기 N
		map = new int[N + 2][N + 2];

		for (int i = 0; i < N + 2; i++) { // 배열의 모든 값을 -1로 초기화
			Arrays.fill(map[i], -1);
		}

		isVisited = new boolean[N + 2][N + 2];
		ans = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j - 1));
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (map[i][j] ==1 && !isVisited[i][j]) { // 집이 있고 아직 방문하지 않았다면 
					ans.add(0);
					dfs(cnt++, i, j);
				}
			}
		}

		sb.append(ans.size()).append("\n"); // 총 단지수
		Collections.sort(ans); // 집의 수 기준으로 오름차순으로 정렬
		for (int n : ans) { // 집의 수를 한 줄에 하나씩 출력
			sb.append(n).append("\n");
		}

		System.out.println(sb);

	}

	private static void dfs(int idx, int x, int y) {
		ans.set(idx, ans.get(idx) + 1); // 현재 단지 수에 저장되어 있는 집의 수를 +1
//		System.out.println(idx + ": " + x + "," + y);
		isVisited[x][y] = true;

		for (int d = 0; d < dirs.length; d++) { // 4방 탐색 
			// 다음 위치 계산 
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];

			if (map[nx][ny] == -1 || map[nx][ny] == 0) { // 배열의 범위를 벗어나거나(-1) 집이 있지 않다면(0) 아래의 과정 생략
				continue;
			}

			if (!isVisited[nx][ny]) { // 아직 방문하지 않았다면 다음 위치로 이동 
				dfs(idx, nx, ny);
			}
		}
	}
}
