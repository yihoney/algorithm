import java.io.*;
import java.util.*;

/**
 * BJ_21610_마법사상어와비바라기 
 * 
 * 1번 행과 N번 행을 연결했고, 1번 열과 N번 열도 연결
 * 비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생김
 * 이동 di: 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ / si: 거리 
 * 
 * [ 코드 ]
 * 1. 입력 받기 
 * 	1. 크기가 N*N인 배열을 생성해 A[r][c] 입력 받기 
 *  2. 비바라기 시전
 *  3. M번 반복문을 돌며 이동 정보 입력 받기 
 *  
 * 2. 구름 이동 시키기 
 *  1. 모든 구름이 di 방향으로 si칸 이동 -> 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가 후 구름 소멸 
 *  2. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전
 *   - 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가 (경계를 넘어서지 않음)
 *  3. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어듦. 
 *   - 구름이 생기는 칸은 2에서 구름이 사라진 칸이 아니어야 함 
 * 
 * 3. 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 출력
 */

public class Main {

	// di 방향벡터
	static int dirs[][] = new int[][] { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 } };
	static int[][] map;
	static Queue<int[]> clouds;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 1.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 1-1
		map = new int[N][N];
		clouds = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 1-2
		makeCloud(N);

		for (int m = 0; m < M; m++) {
			// 1-3
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			// 2.
			move(d, s);
		}

		// 3.
		printSumWater();
	}

	private static void makeCloud(int N) {
		int cloud[][] = new int[][] { { N - 1, 0 }, { N - 1, 1 }, { N - 2, 0 }, { N - 2, 1 } };
		for (int[] c : cloud) {
			clouds.add(c);
		}
	}

	private static void move(int d, int s) {
		boolean flag[][] = new boolean[N][N];
		int size = clouds.size();

		// 2-1
		int cnt = 0;
		while (cnt < size) {
			int[] cur = clouds.poll();
			int nx = (cur[0] + dirs[d - 1][0] * (s % N) + N) % N;
			int ny = (cur[1] + dirs[d - 1][1] * (s % N) + N) % N;
			map[nx][ny] += 1;
			flag[nx][ny] = true;
			clouds.offer(new int[] { nx, ny });
			cnt++;
		}

		// 2-2
		while (!clouds.isEmpty()) {
			int[] cur = clouds.poll();
			int nx = cur[0];
			int ny = cur[1];

			int w = 0;
			for (int i = 1; i < dirs.length; i += 2) {
				int r = nx + dirs[i][0];
				int c = ny + dirs[i][1];

				if (r < 0 || c < 0 || r >= N || c >= N) {
					continue;
				}
				if (map[r][c] > 0) {
					w++;
				}
			}
			map[nx][ny] += w;
		}

		// 2-3
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!flag[r][c] && map[r][c] >= 2) {
					map[r][c] -= 2;
					clouds.offer(new int[] { r, c });
				}
			}
		}

	}

	private static void printSumWater() {
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sum += map[r][c];
			}
		}
		System.out.println(sum);
	}
}
