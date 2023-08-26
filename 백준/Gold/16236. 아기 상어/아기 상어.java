import java.util.*;
import java.io.*;

/**
 * BJ 16236 아기상어
 * 
 * 초기상태: 아기 상어 크기: 2, 1초에 상하좌우 인접한 한 칸씩 이동
 * 
 * - 자신보다 크기가 큰 칸은 지나갈 수 없고 - 자신보다 크기가 작은 물고기는 먹을 수 있고 자신의 크기만큼의 물고기를 먹어야 크기가 1
 * 증가 - 자신이랑 크기가 같은 물고기가 있음 지나갈 수 있음
 * 
 * - 먹을 수 있는 물고기가 1마리: 물고기 먹기 - 먹을 수 있는 물고기가 1마리보다 많으면: 거리가 가장 가까운 물고기 먹기 - 거리가
 * 가까운 물고기가 많다면, 가장 위에 있는 물고기 먹음 / 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹음
 * 
 * 이동하는 데에는 1초 소요, 먹으면 칸에 있던 물고기 사라짐
 * 
 * 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램 -> 더이상 물고기가 없으려면 몇
 * 초가 걸리는지 구하기
 * 
 * @author 이하늬
 */

class Point {
	int x;
	int y;
	int dist;

	Point(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class Main {
	static int[][] arr;
	static int N, ans;
	static Queue<Point> queue;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상, 좌, 하, 우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 배열 크기
		arr = new int[N + 2][N + 2];
		for (int r = 0; r < N + 2; r++) {
			Arrays.fill(arr[r], -1); // 배열의 모든 값 -1로 초기화
		}
		queue = new LinkedList<>();

		// 입력 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) { // 9라면 아기상어가 있는 좌
					queue.add(new Point(i, j, 0)); // 아기상어 시작 좌표 저장
					arr[i][j] = 0; // 아기상어는 돌아다닐거니까 0 저장
				}
			}
		}

		bfs();
		System.out.println(ans); // 정답 출력

	}

	public static void bfs() {

		int size = 2; // 아기상어의 초기 크기 = 2
		int cnt = 0; // 먹은 물고기 수

		while (true) {
			List<Point> fishes = new ArrayList<>(); //
			int[][] dist = new int[N+2][N+2]; // 간 거리 계산하기 위한 배열  

			while (!queue.isEmpty()) { // 큐 빌 때까지  
				Point cur = queue.poll();
				int cx = cur.x;
				int cy = cur.y;

				for (int d = 0; d < dirs.length; d++) {
					int nx = cx + dirs[d][0];
					int ny = cy + dirs[d][1];

					if (arr[cx][cy] != -1) {
						if (dist[nx][ny] == 0 && arr[cx][cy] <= size) { // 아직 한 번도 가지 않고 나보다 크기가 작거나 같은 물고기가 있을 경
							dist[nx][ny] = dist[cx][cy] + 1;
							queue.add(new Point(nx, ny, dist[nx][ny]));
							if (1 <= arr[nx][ny] && arr[nx][ny] <= 6 && arr[nx][ny] < size) {
								fishes.add(new Point(nx, ny, dist[nx][ny]));
							}
						}
					}

				}
			}

			if (fishes.size() == 0) {
				System.out.println(ans);
				System.exit(0);;
			}

			Point fish = fishes.get(0);
			for (int i = 1; i < fishes.size(); i++) {
				if (fish.dist > fishes.get(i).dist) { // 거리가 더 가까운 물고기가 1순위
					fish = fishes.get(i);
				}
				if (fish.dist == fishes.get(i).dist) { // 거리가 같으면
					if (fish.x > fishes.get(i).x) { // 더 위에 있는 물고기가 2순위
						fish = fishes.get(i);
					}
					if (fish.x == fishes.get(i).x) { // 같은 높이에 있으면
						if (fish.y > fishes.get(i).y) { // 더 왼쪽에 있는 물고기가 3순위
							fish = fishes.get(i);
						}
					}
				}
			}

			arr[fish.x][fish.y] = 0; // 물고기 잡아먹어버리고 0 저장 
			cnt++; // 잡아먹은 물고기 수 ++ 
			ans += fish.dist; // 걸린 시간 물고기 거리만큼 더해주기 

			if (size == cnt) { // 아기상어 크기만큼 물고기를 잡아먹었다면
				size++; // 아기상어 크기는 1 커지고
				cnt = 0; // 잡아먹은 물고기는 0으로 초기화
			}
			
			queue.add(fish); // 지금 위치 큐에 넣기 
		}
	}
}