import java.io.*;
import java.util.*;

/**
 * BJ_16234_인구이동
 * 
 * [ 코드 ] 
 * 1. 입력 받기 
 * 2. 연합 국가 찾기 
 *  1. 우선 flag를 true로 두고 반복문을 true일 동안 무한으로 돌게 해둠 
 *  2. 일단 반복문을 돌기 시작하면 flag를 false로 초기화 해둠
 *  3. 국경선을 열지 못하는 경우 false 값을 반환하므로 그럴 경우 반복문을 종료하게 함 
 *  4. 반복문을 돌며 아직 방문하지 않은 나라라면 국경선을 열 수 있는지 체킹 
 *  5. 국경선을 열 수 있는지는 4방 탐색으로 확인.
 *   -> 인접한 나라와 인구 차이가 L명 이상, R명 이하일 경우 국경선 열기 (큐에 삽입)
 *  6. 국경선 열기가 끝났다면 국경선이 열린 나라의 모든 인구 수를 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)로 세팅 
 *  7. 반복문이 한 번 돌았다면 하루가 지났으므로 ans++
 *  
 * 3. 답 출력
 * 
 * @author yihoney
 */

public class Main {
	static int[][] arr;
	static int N, L, R, ans;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean visited[][], flag;

	public static void main(String[] args) throws IOException {
		// 1.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅 N*N
		L = Integer.parseInt(st.nextToken()); // 인구 차이 L명 이상
		R = Integer.parseInt(st.nextToken()); // 인구 차이 R명 이하
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2.
		find();

		// 3.
		System.out.println(ans);
	}

	// 2.
	private static void find() {

		// 2-1
		flag = true;

		while (flag) {
			// 2-2
			flag = false;
			visited = new boolean[N][N];

			// 2-4
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])
						bfs(i, j);
				}
			}

			// 2-3
			if (!flag) {
				return;
			}
			
			// 2-7
			ans++;
		}
	}

	
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();

		List<int[]> list = new ArrayList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;
		int sum = 0;

		// 2-5
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			list.add(new int[] { cur[0], cur[1] });
			sum += arr[cur[0]][cur[1]];

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dirs[d][0];
				int ny = cur[1] + dirs[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				int diff = Math.abs(arr[cur[0]][cur[1]] - arr[nx][ny]);

				if (diff >= L && diff <= R && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}

		// 2-3
		if (list.size() > 1) {
			flag = true;
		}

		// 2-6
		int avg = sum / list.size();

		for (int[] l : list) {
			arr[l[0]][l[1]] = avg;
		}

	}
}
