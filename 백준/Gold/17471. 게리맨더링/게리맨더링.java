import java.io.*;
import java.util.*;

/**
 * BJ_17471_게리맨더링
 * 
 * @author yihoney
 */

public class Main {
	static List<List<Integer>> graph;
	static int[] population;
	static boolean[] selected;
	static int N, ans= Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 구역의 개수 N
		graph = new ArrayList<>();
		selected = new boolean[N];
		
		for (int n = 0; n < N; n++) {
			graph.add(new ArrayList<>());
		}

		population = new int[N + 1]; // 구역의 인구를 저장할 배열
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			population[n] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		}

			recursive(0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void recursive(int cnt) {
		if (cnt == N) { 
			isValid();
			return;
		}

			selected[cnt] = true;
			recursive(cnt + 1);
			selected[cnt] = false;
			recursive(cnt + 1);
			
	}

	private static void isValid() {

		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		int totalA = 0, totalB=0;
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				aList.add(i);
				totalA += population[i];
			}
			if (!selected[i]) {
				bList.add(i);
				totalB += population[i];
			}
		}

		if (totalA == 0 || totalB == 0) {
			return;
		}

		if (!isConnected(aList) || !isConnected(bList)) {
			return;
		}

		ans = Math.min(ans, Math.abs(totalA - totalB));
	}

	private static boolean isConnected(List<Integer> list) {
		boolean flag = false;

		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[N];
		int first = list.get(0);
		visited[first] = true;
		queue.offer(first);

		int cnt = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int n : graph.get(cur)) {
				if (list.contains(n) && !visited[n]) {
					queue.offer(n);
					visited[n] = true;
					cnt++;
				}
			}
		}

		if (cnt == list.size()) {
			flag = true;
		}
		return flag;
	}
}