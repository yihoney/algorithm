import java.util.*;
import java.io.*;

/**
 * 
 * BJ_3055_탈출
 * 
 * 1. 입력 받기 
 * - '*'이라면 waterList에 add 
 * - 'S'이라면 출발위치에 좌표 저장 
 * - 'D'이라면 도착위치에 좌표 저장
 * 
 * 
 * 2. 고슴도치 이동하기 
 * - BFS로 출발위치에서 방향벡터 이용해 갈 수 있는지 확인 후 갈 수 있다면 큐에 삽입 및 시간 ++
 * 
 * 3. 물 확산 시키기 
 * - 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다 -> 물 확산부터 하고 고슴도치가 이동해야 함 
 * - BFS로 확산 가능하다면 확산
 * 
 * 4. 도착위치 도착했다면 종료 
 * - 도착 못하면 "KAKTUS" 출력
 * 
 * 
 * @author yihoney
 *
 */

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static Point start, end;
	static char[][] map;
	static Queue<Point> waters;
	static int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌
	static int[][] visited;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new char[r + 2][c + 2];
		visited = new int[r + 2][c + 2];
		waters = new LinkedList<>();

		// 1.
		for (int i = 1; i <= r; i++) {
			String str = br.readLine();
			for (int j = 1; j <= c; j++) {
				map[i][j] = str.charAt(j - 1);
				if (map[i][j] == '*') {
					waters.add(new Point(i, j));
				}
				if (map[i][j] == 'S') {
					start = new Point(i, j);
				}
				if (map[i][j] == 'D') {
					end = new Point(i, j);
				}
			}
		}

		bfs();

		// 4.
		if (visited[end.x][end.y] == 0) {
			System.out.println("KAKTUS");
			return;
		}
		System.out.println(visited[end.x][end.y]);
	}

	// 2.
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {


			spreadWater();

			int size = queue.size();
			int cnt = 0;
			
			while (cnt < size) {
				Point cur = queue.poll();
				int cx = cur.x;
				int cy = cur.y;

				if (map[cx][cy] == 'D') { // 도착 위치에 도착했다면
					return;
				}

				for (int d = 0; d < dirs.length; d++) {
					int nx = cx + dirs[d][0];
					int ny = cy + dirs[d][1];

					if (map[nx][ny] == ' ') {
						continue;
					}

					if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && visited[nx][ny] == 0) { // 갈 수 있다면
						queue.offer(new Point(nx, ny));
						visited[nx][ny] = visited[cx][cy] + 1;
					}
				}
				cnt++;
			}
		}
	}

	// 3.
	private static void spreadWater() {
		int size = waters.size();
		int cnt = 0;

		while (cnt < size) {
			Point curWaterPoint = waters.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nx = curWaterPoint.x + dirs[d][0];
				int ny = curWaterPoint.y + dirs[d][1];

				if(map[nx][ny] == ' ') {
					continue;
				}
				
				// 비어있는 칸이라 물을 확장할 수 있다면
				if (map[nx][ny] == '.') {
					map[nx][ny] = '*';
					waters.offer(new Point(nx, ny));
				}
			}
			cnt++;
		}
	}

}
