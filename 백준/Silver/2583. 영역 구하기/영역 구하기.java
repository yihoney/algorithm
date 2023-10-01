import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] map;
	static int M, N, K, cnt;
	static List<Integer> area;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 모눈종이 세로 길이
		N = Integer.parseInt(st.nextToken()); // 모눈종이 가로 길이
		K = Integer.parseInt(st.nextToken()); // 직사각형 갯수

		map = new int[M][N];
		area = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			fillMap(start, end);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		printAns();
	}

	private static void fillMap(Point start, Point end) {
		for (int r = start.y; r < end.y; r++) {
			for (int c = start.x; c < end.x; c++) {
				map[r][c] = 1;
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		int sum = 0;
		queue.offer(new Point(i, j));
		map[i][j] = 2;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			sum++;

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dirs[d][0];
				int ny = cur.y + dirs[d][1];

				if(nx<0 || ny<0 || nx>=M || ny >=N) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
					queue.offer(new Point(nx, ny));
					map[nx][ny] = 2;
				}

			}
		}
		area.add(sum);
	}
	
	private static void printAns() {
		sb.append(cnt).append("\n");
		Collections.sort(area);
		for(int i=0; i<area.size() ;i++) {
			sb.append(area.get(i)).append(" ");
		}
		System.out.println(sb);
	}

}