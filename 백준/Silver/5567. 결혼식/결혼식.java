import java.util.*;
import java.io.*;

/**
 * BJ 5567 결혼식
 * 
 * ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다. -> 친구 관계를 양방향 그래프에 저장
 */

public class Main {
	static List<Integer>[] graph;
	static int n, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 상근이의 동기의 수
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		int m = Integer.parseInt(br.readLine()); // 친구 관계 리스트의 길이
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		if (graph[1].size() == 0) {
			System.out.println(0);
			return;
		}

		BFS();

		System.out.println(ans);
	}

	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[n + 1];
		int[] depth = new int[n + 1];
		q.add(1);
		isVisited[1] = true;

		while (!q.isEmpty()) {

			int cur = q.poll();

			if (depth[cur] == 2) {
				return;
			}

			for (int i = 0; i < graph[cur].size(); i++) {
				int n = graph[cur].get(i);

				if (!isVisited[n]) {
					q.add(n);
					isVisited[n] = true;
					depth[n] = depth[cur] + 1;
					ans++;
				}
			}
		}

	}
}