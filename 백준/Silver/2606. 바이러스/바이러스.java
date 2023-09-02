import java.io.*;
import java.util.*;

/**
 * BJ 2606 바이러스
 * 
 * 네트워크 상에 연결 되어 있는 컴퓨터 수를 구하는 문제 -> BFS 이용 연결 정보를 인접리스에 저장. 양방향!
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= N; i++) { // 그래프 초기화
			graph.add(new ArrayList<Integer>());
		}

		int M = Integer.parseInt(br.readLine()); // 네트워크 상에 연결되어 있는 컴퓨터의 쌍의 수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph.get(from).add(to);
			graph.get(to).add(from);
		}

		int ans = 0;
		
		boolean isVisited[] = new boolean[N + 1]; // 컴퓨터가 1번부터 시작하므로 편의상 N+1 크기 방문 배열 생성
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1); // 1번 컴퓨터 기준으로 연결된 컴퓨터의 수를 구해야하므로 1 우선 삽입
		isVisited[1] = true; // 1번 컴퓨터 방문 배열 플래그 true로 변경

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < graph.get(cur).size(); i++) {
				int next = graph.get(cur).get(i);
				if(!isVisited[next]) { // i번째 컴퓨터를 아직 방문 안했다면 
					queue.offer(next); // 큐에 삽입 하고 
					isVisited[next] = true; // 방문 플래그 변경 
					ans++; // 카운트 ++ 
				}
			}
		}

		System.out.println(ans);
	}

}