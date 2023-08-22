import java.util.*;
import java.io.*;

/*
 * <SWEA D4 3289 서로소집합>
 * 
 * DisjointSet 이용해 해결해보겠슴니당

 */
public class Solution {

	static int[] p; // 대표자 저장해둘 집합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 서로소집합 갯수
			int M = Integer.parseInt(st.nextToken()); // 입력 연산 갯수

			make(N); // N개의 서로소집합 생성하기

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());

				if (command == 0) { // union 연산 수행
					union(n1, n2);
				}
				if (command == 1) { // find 연산 수행 시 같은 값이면 같은 집합에 속해있다는 의미
					int ans = find(n1) == find(n2) ? 1 : 0;
					sb.append(ans);
				}

			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void make(int n) {
		p = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}

	private static boolean union(int n1, int n2) {

		int repN1 = find(n1);
		int repN2 = find(n2);

		if (repN1 == repN2) { // 대표자가 같으면
			return false; // 이미 같은 집합
		}

		p[repN2] = p[repN1];
		return true;
	}

	private static int find(int n) {
		if (n == p[n]) {
			return n;
		}

		return p[n] = find(p[n]);
	}
}