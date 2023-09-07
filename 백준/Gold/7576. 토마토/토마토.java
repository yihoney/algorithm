import java.util.*;
import java.io.*;

/**
 * BJ 7576 토마토
 * 
 * 모든 토마토가 익을 때까지 소요되는 최소 시간 계산하기 -> BFS 이용
 * 
 * 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않음
 * 
 * 익은 토마토(1)를 만났을 때 인접한 토마토들은 익음 (왼쪽, 오른쪽, 앞, 뒤)
 */

public class Main {

	static int dirs[][] = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static int box[][];
	static int M, N, ans;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 상자 크기 M (가로 칸의 수)
		N = Integer.parseInt(st.nextToken()); // 상자 크기 N (세로 칸의 수)

		box = new int[N + 2][M + 2];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken());
				if (box[n][m] == 1) {
					queue.add(new int[] { n, m });
				}
			}
		}

		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int d = 0; d < dirs.length; d++) {
				int nx = cx + dirs[d][0];
				int ny = cy + dirs[d][1];

				if (!isInArray(nx, ny)) {
					continue;
				}

				if (box[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny });
					box[nx][ny] = box[cx][cy] + 1;
				}
			}
		}

		int days = Integer.MIN_VALUE;
		if (check()) {
            ans = -1;
        } else {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (days < box[i][j]) {
                    	days = box[i][j];
                    }
                }
            }

            ans= days - 1;
        }

	}

	private static boolean isInArray(int nx, int ny) {
		if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (box[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
