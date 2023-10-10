import java.util.*;
import java.io.*;

public class Solution {

	static List<List<Integer>> graph;
	static int N, M, ans;
	static int p[];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			for (int n = 0; n <= N; n++) {
				graph.add(new ArrayList<>());
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				graph.get(p1).add(p2);
				graph.get(p2).add(p1);
			}

			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (visited[i]) {
					continue;
				}
				getGroupCnt_DFS(i);
				ans++;
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	private static void getGroupCnt_DFS(int idx) {

		visited[idx] = true;
		List<Integer> list = graph.get(idx);
		for (int m = 0; m < list.size(); m++) {
			int cur = list.get(m);
			if (!visited[cur]) {
				getGroupCnt_DFS(cur); // 다음 사람 살펴보기
			}
		}
	}
}