import java.io.*;
import java.util.*;

/**
 * BJ_15683_감시
 * 
 * 구현하는데 200줄 넘어가길래 이게 맞나 싶어서 큐 코드 참고..
 * 큐는 신이다..!
 * 
 * 구현+DFS!!
 * cctv 번호마다 경우의수를 나눠서 순열 생성하여 사각지대 계산 
 * 
 * @author yihoney
 */

class Point {
	int x, y, n;

	Point(int x, int y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
}

public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
	static int map[][], numbers[];
	static int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static List<Point> cctvList;
	static int[][][] caseArr = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, // 1번 카메라가 감시할 수 있는 경우의 수
			{ { 0, 2 }, { 1, 3 } }, // 2번 카메라가 감시할 수 있는 경우의 수
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3번 카메라가 감시할 수 있는 경우의 수
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } }, // 4번 카메라가 감시할 수 있는 경우의 수
			{ { 0, 1, 2, 3 } } // 5번 카메라가 감시할 수 있는 경우의 수
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvList = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				// cctv이면 (벽이 아니거나 빈칸이 아니면)
				if (map[n][m] > 0 && map[n][m] < 6) {
					cctvList.add(new Point(n, m, map[n][m]));
				}

			}
		}

		numbers = new int[cctvList.size()];

		dfs(0);

		System.out.println(ans);
	}

	private static boolean isInMap(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return false;
		}
		return true;
	}

	private static void dfs(int cnt) {
		if (cnt == cctvList.size()) {
			int[][] mapClone = new int[N][M];
			for (int i = 0; i < N; i++) {
				mapClone[i] = map[i].clone();
			}

			for (int c = 0; c < cctvList.size(); c++) {
				Point cctv = cctvList.get(c);

				for (int ca : caseArr[cctv.n][numbers[c]]) {
					int cx = cctv.x;
					int cy = cctv.y;
					while (true) {
						cx += dirs[ca][0];
						cy += dirs[ca][1];
						// 범위를 벗어나거나 벽을 만나면 
						if (!isInMap(cx, cy) || mapClone[cx][cy] == 6) {
							break;
						}
						if (mapClone[cx][cy] > 0 && mapClone[cx][cy] < 6) {
							continue;
						}
						mapClone[cx][cy] = -1;
					}
				}
			}

			int tmp = solution(mapClone);

			ans = Math.min(ans, tmp);

			return;
		}

		// 중복 순열 생성
		for (int i = 0; i < caseArr[cctvList.get(cnt).n].length; i++) {
			numbers[cnt] = i;
			dfs(cnt + 1);
		}
	}

	private static int solution(int[][] arr) {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (arr[r][c] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}