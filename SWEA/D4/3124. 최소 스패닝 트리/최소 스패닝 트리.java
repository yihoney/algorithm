import java.util.*;
import java.io.*;

/**
 * D4 3124 최소 스패닝 트리
 * 
 * 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리 구하기
 *
 */

class Edge implements Comparable<Edge> {
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}

}

public class Solution {

	static Edge graph[];
	static StringBuilder sb = new StringBuilder();
	static int p[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			graph = new Edge[E];

			int from, to, weight;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				graph[e] = new Edge(from, to, weight);
			}

			Arrays.sort(graph);
			
			make(V);

			long ans = 0L;
			int cnt = 0;

			for (Edge e : graph) {
				if (union(e.from, e.to)) {
					ans += (long) e.weight;
					if (++cnt == V - 1) {
						break;
					}
				}

			}

			sb.append((long) ans).append("\n");
		}

		System.out.println(sb);
	}

	private static void make(int n) {
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
	}

	private static int find(int n) {
		if (p[n] == n) {
			return n;
		}

		return p[n] = find(p[n]);
	}

	private static boolean union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);

		if (root1 == root2) {
			return false;
		}

		p[root2] = root1;
		return true;
	}

}