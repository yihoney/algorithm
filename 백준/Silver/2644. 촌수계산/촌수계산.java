import java.util.*;
import java.io.*;

/**
 * BJ 2644 촌수계산
 * 
 * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 문제 -> 입력 받은 부모 자식 관계를
 * 인접리스트에 저장하고(양방향), DFS 이용하여 해결
 */

public class Main {
	static ArrayList<Integer>[] graph;
	static int n2, M, ans;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 전체 사람의 수 N
		graph = new ArrayList[N + 1];
		isVisited = new boolean[N + 1]; // 방문 플래그 배열

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(br.readLine());
		// 촌수를 계산해야 하는 서로 다른 두 사람의 번호
		int n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계 개수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			graph[parent].add(child);
			graph[child].add(parent);
		}

		dfs(n1, 0);
		if (ans == 0) { // 찾으려는 사람을 못찾아 ans가 0이라면
			ans = -1; // 촌수를 계산할 수 없으므로 -1 저장
		}
		System.out.println(ans);
	}

	private static void dfs(int start, int cnt) {

		if (start == n2) { // 기저조건 -> 찾으려는 수를 만나면 종료
			ans = cnt; // ans에 현재까지 함수를 호출한 횟수를 저장
			return; // 종료
		}

		isVisited[start] = true;

		for (int i = 0; i < graph[start].size(); i++) {
			int cur = graph[start].get(i);
			if (!isVisited[cur]) { // 아직 방문 안 한 사람일 경우에 방문
				dfs(cur, cnt + 1); // 다음 사람으로 이동
			}
		}
	}
}