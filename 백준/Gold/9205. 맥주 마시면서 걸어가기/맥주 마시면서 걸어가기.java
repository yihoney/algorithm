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
	static int arr[][], N;
	static Point start, store[], end;
	static boolean ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 맥주를 파는 편의점의 갯수
			
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			store = new Point[N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				store[n] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			ans = false;
			bfs();
			
			System.out.println(ans ? "happy" : "sad");
		}

	}

	private static void bfs() {

		boolean visited[] = new boolean[N];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (getDistance(cur, end) <= 50 * 20) {
				ans = true;
				return;
			}

			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					Point next = store[i];
					if (getDistance(cur, next) <= 50 * 20) {
						visited[i] = true;
						queue.offer(next);
					}
				}
			}
		}

		ans = false;

	}

	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
