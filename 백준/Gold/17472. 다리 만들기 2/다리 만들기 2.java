import java.io.*;
import java.util.*;

/**
 * BJ_17472_다리만들기2
 * 
 * - 모든 섬이 연결됐는지 확인 => 섬이 연결될 때마다 set에 섬을 추가해 최종적으로 set.size()가 섬 갯수와 같은지 확인 -
 * 
 * @author yihoney
 */

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class MstNode implements Comparable<MstNode> {
	int island1, island2, length;

	MstNode(int island1, int island2, int length) {
		this.island1 = island1;
		this.island2 = island2;
		this.length = length;
	}

	@Override
	public int compareTo(MstNode o) {
		return this.length - o.length;
	}
}

public class Main {
	static int N, M, cnt, ans;
	static int graph[][], p[];
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static List<List<Node>> islands;
	static PriorityQueue<MstNode> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬마다 다른 번호 부여
		visited = new boolean[N][M];
		islands = new ArrayList<>();
		for (int i = 0; i <= 6; i++) {
			islands.add(new ArrayList<Node>());
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (graph[r][c] == 1 && !visited[r][c]) {
					cnt++;
					markIsland(r, c);
//					System.out.println("cnt: " + cnt);
//					printGraph();
				}
			}
		}

		// 섬과 섬 연결하기 - 다리 짓기
		pq = new PriorityQueue<>();
		for (int i = 1; i < islands.size(); i++) {
			for (int j = 0; j < islands.get(i).size(); j++) {
				Node island = islands.get(i).get(j);
				for (int d = 0; d < dirs.length; d++) {
					buildBridge(island.x, island.y, i, d, -1);
				}
			}
		}

		// 다리의 총 최소 길이를 구하기
		kruskal();

		System.out.println(ans);
	}

	private static void kruskal() {

		// 서로소 집합 생성하는 메서드
		p = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			p[i] = i;
		}

		boolean[] linked = new boolean[cnt + 1];
		int bridge = 0;

		while (!pq.isEmpty()) {
			MstNode cur = pq.poll();

			int p1 = find(cur.island1);
			int p2 = find(cur.island2);

			if (p1 != p2) {
				union(p1, p2);
				linked[p1] = true;
				linked[p2] = true;
				ans += cur.length;
				bridge++;
			}
		}

		// 총 다리 길이가 0 이거나 다리 갯수가 모든 섬의 - 1 개가 아니라면
		if (ans == 0 || bridge != cnt - 1) {
			System.out.println(-1);
			System.exit(0);
		}

	}

	private static int find(int n) {
		if (p[n] == n) {
			return n;
		}

		return p[n] = find(p[n]);
	}

	private static void union(int i1, int i2) {
		p[i2] = i1;
	}

	private static void buildBridge(int x, int y, int startIsland, int d, int len) {

		int curIsland = graph[x][y];
		// 현재 위치가 섬이고, 시작 섬과 다른 섬이라면

		if (curIsland != 0 && curIsland != startIsland) {
			if (len >= 2) { // 다리 길이가 2 이상이라면
				pq.offer(new MstNode(startIsland, curIsland, len));
			}
			return;
		}

		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];

		// 다음 위치가 배열의 범위를 벗어났거나 시작 섬과 같은 섬이라면 종료
		if (!isValidScope(nx, ny) || graph[nx][ny] == startIsland) {
			return;
		}

		buildBridge(nx, ny, startIsland, d, len + 1);
	}

	private static void markIsland(int r, int c) {
		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(new Node ( r, c ));
		visited[r][c] = true;

		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			islands.get(cnt).add(new Node(cur.x, cur.y));
			graph[cur.x][cur.y] = cnt;

			for (int d = 0; d < dirs.length; d++) {
				int nx = cur.x + dirs[d][0];
				int ny = cur.y + dirs[d][1];

				if (!isValidScope(nx, ny)) {
					continue;
				}

				if (graph[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new Node (nx, ny ));
					visited[nx][ny] = true;
				}
			}
		}

	}

	private static boolean isValidScope(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return false;
		}

		return true;
	}

//	private static void printGraph() {
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < M; c++) {
//				System.out.print(graph[r][c] + " ");
//			}
//			System.out.println();
//		}
//	}
}
