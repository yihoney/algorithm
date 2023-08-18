import java.io.*;
import java.util.*;

/**
 * BJ 2178 미로탐색
 * 
 * 최소의 칸 수를 구하는 문제 -> bfs!!
 * 
 */

public class Main {
	static int[][] arr;
	// 탐색할 방향벡터 (상, 하, 좌, 우)
	static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 미로 크기. 행
		M = Integer.parseInt(st.nextToken()); // 미로 크기. 열
		arr = new int[N + 2][M + 2]; // 테두리 0으로 패딩

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j - 1));
			}
		}

		bfs();

		System.out.println(arr[N][M]); // 최종 도착지의 값 출력
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[N + 2][M + 2];

		queue.offer(new int[] { 1, 1 });
		isVisited[1][1] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // 현재 칸
			int cx = current[0];
			int cy = current[1];

			int nx, ny; // 앞으로 갈 칸
			for (int i = 0; i < dirs.length; i++) {
				// 칸 계산 -> 기존 칸에 방향벡터 더해주기
				nx = cx + dirs[i][0];
				ny = cy + dirs[i][1];

				if (arr[nx][ny] == 0) { // 갈 수 없거나 미로 범위 벗어났을 때
					continue;
				}

				if (isVisited[nx][ny]) {// 이미 방문했을 때
					continue;
				}

				// 위의 상황이 아니고 갈 수 있는 길이라면
				queue.offer(new int[] { nx, ny }); // 탐색해야되는 칸 큐에 추가
				isVisited[nx][ny] = true; // 탐색해야되는 칸 찜콩
				arr[nx][ny] = arr[cx][cy] + 1; // 앞으로 갈 칸의 값을 현재까지 지난 칸의 수 + 1로 바꿔줌
			}

		}

	}
}
