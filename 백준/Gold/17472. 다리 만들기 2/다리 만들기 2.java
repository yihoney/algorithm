import java.io.*;
import java.util.*;

/**
 * BJ_17472_다리만들기2
 * 
 * - BFS: 섬마다 각 다른 번호 부여하기 
 * - DFS: 다리 지어 섬과 섬 연결하기 
 * - MST: 최소 총 다리 길이 구하기 
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
	int from, to, length;

	MstNode(int island1, int island2, int length) {
		this.from = island1;
		this.to = island2;
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

	/**
	 * 배열의 범위 안에 있는지 확인하는 메서드 
	 * @param nx 기준 x좌표 
	 * @param ny 기준 y좌표 
	 * @return 범위 안에 있다면 true를, 범위를 벗어난다면 false를 반환 
	 */
	private static boolean isValidScope(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return false;
		}

		return true;
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

		// 다음 위치 계산 
		int nx = x + dirs[d][0];
		int ny = y + dirs[d][1];

		// 다음 위치가 배열의 범위를 벗어났거나 시작 섬과 같은 섬이라면 종료
		if (!isValidScope(nx, ny) || graph[nx][ny] == startIsland) {
			return;
		}

		// 다음 좌표로 이동 (좌표는 계산한 좌표로, 길이는 현재 길이 + 1로 변경)
		buildBridge(nx, ny, startIsland, d, len + 1);
	}

	
	private static void kruskal() {

		// 서로소 집합 생성하는 메서드
		p = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			p[i] = i;
		}

		// 연결 여부 저장할 플래그 배열 
		boolean[] linked = new boolean[cnt + 1];
		// 다리 갯수 저장할 변수 
		int bridge = 0;

		while (!pq.isEmpty()) {
			MstNode cur = pq.poll();

			// 각 섬의 집합 대표자 번호 찾기 
			int p1 = find(cur.from);
			int p2 = find(cur.to);

			if (p1 != p2) { // 다른 집합에 속해있다면 
				union(p1, p2); // p1과 p2 같은 집합으로 합쳐주기 
				// 연결 여부 true로 변경 
				linked[p1] = true; 
				linked[p2] = true;
				ans += cur.length; // 총 다리 길이에 현재 다리 길이 더해주기 
				bridge++; // 연결된 다리 갯수 1개 더해주기 
			}
		}

		// 총 다리 길이가 0 이거나 다리 갯수가 모든 섬의 - 1 개가 아니라면
		if (ans == 0 || bridge != cnt - 1) {
			System.out.println(-1);
			System.exit(0);
		}

	}

	/**
	 * 집합의 대표자 번호 찾는 메서드 
	 * @param n 대표자를 찾을 섬 
	 * @return 섬이 속해있는 집합의 대표자 
	 */
	private static int find(int n) {
		if (p[n] == n) {
			return n;
		}

		return p[n] = find(p[n]);
	}

	/**
	 * i1과 i2 같은 집합으로 합치기 
	 * @param p1 합칠 섬 1의 대표자 
	 * @param p2 합칠 섬 2의 대표자 
	 */
	private static void union(int p1, int p2) {
		p[p2] = p1; // i2의 대표자를 i1의 대표자로 설정 
	}
}
