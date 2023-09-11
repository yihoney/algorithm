import java.io.*;
import java.util.*;

/**
 * BJ 15663 N과 M (9) N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제
 * N개의 자연수 중에서 M개를 고른 수열
 * 
 * LinkedHashSet을 사용해야 ADD 한 순서대로 값이 저장
 * 
 * @author 이하늬
 *
 */

public class Main {
	static int N, M;
	static int[] arr, numbers;
	static boolean[] isVisited;
	static Set<String> set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 후보군 자연수 갯수
		M = Integer.parseInt(st.nextToken()); // 수열의 길이

		arr = new int[N];
		isVisited = new boolean[N];
		numbers = new int[M]; // 생성한 수열을 담을 배열
		set = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // 사전순으로 출력하기 위함

		perm(0);
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			StringBuilder builder = new StringBuilder();
			for (int n: numbers) {
				builder.append(n).append(" ");
			}
			set.add(builder.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			numbers[cnt] = arr[i];
			perm(cnt + 1);
			isVisited[i] = false;
		}
	}
}