import java.util.*;
import java.io.*;

public class Solution {

	static List<List<Integer>> graph;
	static int N, M, ans;
	static int p[];

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

			getGroupCnt();

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	private static void getGroupCnt() {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[N + 1];

		for (int idx = 1; idx <= N; idx++) {
			if (visited[idx]) {
				continue;
			}
			
			queue.offer(idx);
			
			while (!queue.isEmpty()) {
				int n = queue.poll();
				visited[n] = true;
				List<Integer> list = graph.get(n);
				for (int m = 0; m < list.size(); m++) {
					int cur = list.get(m);
					if (!visited[cur]) {
						queue.offer(cur);
					}
				}
			}
			
			ans++;
		}
	}
}