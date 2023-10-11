import java.util.*;
import java.io.*;

/**
 * <pre>
 * 장애물: 1, 소용돌이: 2 (2초동안 유지, 1초동안 잠잠)
 * 시작점에서부터 도착지점까지 가장 빠른 길로 갔을 때 걸리는 시간 => bfs 이용 
 * </pre>
 * 
 * @author yihoney
 *
 */

public class Solution {
	static int N, ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] start, end;
	static List<int[]> whirlpoolList;
	static int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			ans = -1; // 도착 못했다면 해당 값이 소요 시간으로 갱신되지 못하므로 초깃갓을 -1로 변경 
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			whirlpoolList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) { // 소용돌이라면 소용돌이 리스트에 추가
						whirlpoolList.add(new int[] { i, j });
					}
				}
			}

			st = new StringTokenizer(br.readLine());
			start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			st = new StringTokenizer(br.readLine());
			end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			bfs();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	/**
	 * 
	 * @param r 현재 위치
	 * @param c 현재 위치
	 * @param s 현재 시간 (단위: s)
	 */

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();

		// 시작점 방문 및 방문 플래그 변경 
		queue.offer(new int[] { start[0], start[1], 0 });
		visited[start[0]][start[1]] = true;


		while (!queue.isEmpty()) {

			// 현재 정보 (x좌표, y좌표, 소요 시간)
			int[] cur = queue.poll();

			int cx = cur[0];
			int cy = cur[1];
			int cs = cur[2];

			if (cx == end[0] && cy == end[1]) { // 도착 지점에 도착하면
				ans = cs;
				return;
			}

			for (int d = 0; d < dirs.length; d++) { // 4방 탐색 
				int nx = cx + dirs[d][0];
				int ny = cy + dirs[d][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 배열범위를 벗어났다면 
					continue;
				}
				
				if (arr[nx][ny] == 1 || visited[nx][ny]) { // 장애물이 있거나 이미 방문한 곳이라면 
					continue;
				}

				if (arr[nx][ny] == 0) { // 소용돌이가 없고 장애물이 없어 갈 수 있다면 
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, cs + 1 });
				}

				if (arr[nx][ny] == 2) { // 소용돌이가 있다면 
					if (cs % 3 == 2) { // 소용돌이가 소멸되는 시간이라면
						// 정상적으로 다음 위치 방문 
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny, cs + 1 });
					}

					if (cs % 3 == 0 || cs % 3 == 1) { // 소용돌이 존재하는 시간이라면 
						queue.offer(new int[] { cx, cy, cs + 1 }); // 현재 위치랑 소요시간+1 해서 큐에 삽입 
					}
				}
			}

		}
	}

}