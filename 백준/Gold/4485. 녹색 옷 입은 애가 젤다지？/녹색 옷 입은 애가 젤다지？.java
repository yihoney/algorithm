import java.io.*;
import java.util.*;

/**
 * BJ_4485_녹색옷입은애가젤다지?
 * 
 * [ 코드 ] 
 * 1. 입력 받기 
 * 2. 이동하기 
 *  1. BFS로 4방 탐색 하며 가장 적은 도둑루피의 크기가 있는 곳으로 이동하기 
 * 3. 출력하기
 *  1. StringBuilder에 각 테스트 케이스마다 양식에 맞게 추가해두기
 *  2. bfs() 수행 후 마지막 위치에서의 k루피 값 출력
 * 
 * @author yihoney
 *
 */

public class Main {
	static int N;
	static int[][] map, visited;
	static int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = 0;

		// 1.
		while (true) {
			T++;

			N = Integer.parseInt(br.readLine());

			if (N == 0) { // N=0 이라면 전체 입력 종료
				// 3.
				System.out.println(sb);
				System.exit(0);
			}

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 2.
			bfs();
			
			// 3-1
			sb.append("Problem ").append(T).append(": ");
			// 3-2
			sb.append(visited[N - 1][N - 1]).append("\n");
		}

		
	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		// 잃은 k 루피를 저장해둘 배열 
		visited = new int[N][N];

		queue.offer(new int[] { 0, 0 });
		
		// 각 위치마다 최소 한번씩은 비교 연산을 수행해야 하므로 최댓값으로 초기화
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		// 시작점 큐에 추가
		visited[0][0] = map[0][0]; // 첫 시작점은 무조건 잃어야 하므로 k루피 저장 

		while (!queue.isEmpty()) {
			int cur[] = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nx = cur[0] + dirs[d][0];
				int ny = cur[1] + dirs[d][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) { // map 범위 벗어나면 이후 과정 생략
					continue;
				}

				// 현재 위치까지 오는 데 잃어야하는 k루피 + 다음 위치에서의  k루피가 
				// 다음 좌표까지 가는 데 잃어야하는 k루피보다 작다면
				if (visited[nx][ny] > visited[cur[0]][cur[1]] + map[nx][ny]) {
					visited[nx][ny] = visited[cur[0]][cur[1]] + map[nx][ny]; // 최소값을 갱신
					queue.offer(new int[] { nx, ny }); // 다음 좌표를 탐색하기 위해 큐에 삽입 
				}
			}
		}
	}
}