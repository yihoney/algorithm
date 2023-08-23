import java.util.*;
import java.io.*;

/**
 * D4 3124 최소 스패닝 트리
 * 
 * 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리 구하기
 * 크루스칼 알고리즘 이용 ! 
 * 
 * @author 이하늬
 *
 */

class Edge { // 정점의 연결 관계를 관리하기 위한 클래스
	int from, to, weight; // from 정점과 to 정점이 가중치가 weight인 간선으로 연결되어 있음

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class Solution {

	static Edge graph[]; // 연결된  간선들을 담아둘 배열
	static StringBuilder sb = new StringBuilder(); // 출력을 위한 객체
	static int p[]; // 대표자 집합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" "); // 출력 양식

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점 개수
			int E = Integer.parseInt(st.nextToken()); // 간선 개수

			graph = new Edge[E];

			int from, to, weight;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken()); // 정점 A
				to = Integer.parseInt(st.nextToken()); // 정점 B
				weight = Integer.parseInt(st.nextToken()); // 간선의 가중치
				graph[e] = new Edge(from, to, weight); // 정점 연결 관계를 담은 Edge 객체 생성하여 배열에 저장
			}

			// 오름차순 정렬
			Arrays.sort(graph, (e1, e2) -> e1.weight - e2.weight);
			
			make(V); // 서로소 집합 생성

			long ans = 0L; // 최소 스패닝 트리의 가중치를 계산해 저장할 변수
			int cnt = 0; // 연결된 

			for (Edge e : graph) { // 모든 연결 관계를 한 번씩 살펴보기
				if (union(e.from, e.to)) { // 두 정점의 합집합 연산 수행 성공하면
					ans += e.weight; // 해당 간선의 가중치 더해줌 
					if (++cnt == V - 1) { // 최소신장트리의 간선 개수는 정점-1개 여야함
						break; // 가중치 계산 종료
					}
				}

			}

			sb.append(ans).append("\n"); // 최소 스패닝 트리의 가중치 stringBuilder에 추가
		}

		System.out.println(sb); // 출력
	}

	/**
	 * 서로소 집합 생성하는 메서드
	 * @param n 집합 개수 (1~n)
	 */
	private static void make(int n) {
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
	}

	/**
	 * 집합의 대표자를 찾는 메서드
	 * @param n 대표자를 찾을 숫자
	 * @return n이 속해있는 집합의 대표자
	 */
	private static int find(int n) {
		if (p[n] == n) { // 자기 자신이 대표자라면 
			return n; // 자기 자신을 반환
		}

		// 자기 자신이 대표가 아니라면
		return p[n] = find(p[n]); // 재귀로 대표자를 찾아 저장 및 반환
	}

	/**
	 * 합집합 연산을 수행하는 메서드
	 * @param n1 연산을 수행할 숫자 1
	 * @param n2 연산을 수행할 숫자 2
	 * @return 합집합 연산 수행 여부
	 */
	private static boolean union(int n1, int n2) {
		int root1 = find(n1); // n1의 대표자
		int root2 = find(n2); // n2의 대표자

		if (root1 == root2) { // 대표자가 같다면
			return false; // 합집합을 수행할 수 없기 때문에 false 반환
		}

		p[root2] = root1; // n2의 대표자를 n1의 대표자로 설정
		return true; // 합집합을 수행했기 때문에 true 반환
	}

}
