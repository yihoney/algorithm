import java.io.*;
import java.util.*;

/**
 * 백준 14502 연구소 
 * 
 * 1. 3개의 벽을 세우는 위치를 고를 때 -> DFS 
 * 2. 바이러스가 퍼지는 과정 -> BFS 
 * 3. 0인 곳 개수 세서 0의 개수가 최대가 될 때 찾기 
 * 
 * @author yihoney
 */

public class Main {
	static int n, m, ans;
	static int arr[][];
	static List<int[]> virusList;
//	static List<int[]> possibleList;
	static final int NUM = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 2][m + 2];
//		possibleList = new ArrayList<>();
		virusList = new ArrayList<>();

		for (int i = 0; i < n + 2; i++) {
			Arrays.fill(arr[i], -1);
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				if (arr[i][j] == 0) { // 벽세우기가 가능한곳 리스트에 저장
//					possibleList.add(new int[] { i, j });
//				}
				if (arr[i][j] == 2) { // 바이러스가 퍼진 곳 리스트에 저장
					virusList.add(new int[] { i, j });
				}
			}
		}

		ans = Integer.MIN_VALUE;
		comb(0);

		System.out.println(ans);
	}

	public static void comb(int cnt) {
		if (cnt == NUM) { // 벽 3개를 세웠다면 
			spreadVirus(); // 바이러스 퍼뜨리기 
			return;
		}

//		for (int i = 0; i < possibleList.size(); i++) {
//			int[] pos = possibleList.get(i);
//			arr[pos[0]][pos[1]] = 1;
//			comb(cnt + 1);
//			arr[pos[0]][pos[1]] = 0;
//		}
		
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    comb(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }

	}

	private static void spreadVirus() {
		// 기존 배열을 변경하지 않기 위해 깊은 복사로 배열 하나 복사 
		int[][] map = new int[n + 2][m + 2];
		for (int i = 0; i < n + 2; i++) {
			map[i] = Arrays.copyOf(arr[i], arr[i].length);
		}

		int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		Queue<int[]> queue = new LinkedList<>();

		for (int[] pos : virusList) {
			queue.offer(pos);
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < dirs.length; d++) {

				int nx = cur[0] + dirs[d][0];
				int ny = cur[1] + dirs[d][1];

				if (map[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny });
					map[nx][ny] = 2;
				}
			}
		}

		countSafeZone(map);
	}

	private static void countSafeZone(int[][] map) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		// 기존의 최댓값과 현재 안전 영역 크기 비교하여 더 큰 값 저장해서 안전 영역 크기의 최댓값 구하기 
		ans = Math.max(ans, cnt);
	}
}