import java.util.*;
import java.io.*;

public class Solution {

	static int N, L, ans, arr[][];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 개수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			arr = new int[N][2]; // 재료의 점수와 칼로리를 저장할 배열

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			isSelected = new boolean[N];
			ans = Integer.MIN_VALUE;
			subset(0, 0, 0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void subset(int cnt, int sumKcal, int sumScore) {
		if (cnt == N) {
			if (sumKcal <= L) {
				ans = Math.max(ans, sumScore);
			}
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1, sumKcal + arr[cnt][1], sumScore + arr[cnt][0]);
		isSelected[cnt] = false;
		subset(cnt + 1, sumKcal, sumScore);
	}
}
