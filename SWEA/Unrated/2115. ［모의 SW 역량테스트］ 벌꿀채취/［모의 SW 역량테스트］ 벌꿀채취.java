import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, C, ans, max, a[][];

	static void calc(int r, int c, int cLimit, int sum, int totalSum) {

		if (sum > C) { // 채취 가능한 꿀의 최대 양 초과했다면
			return;
		}

		if (c == cLimit) {
			max = Math.max(max, totalSum);
			return;
		}

		calc(r, c + 1, cLimit, sum + a[r][c], totalSum + a[r][c] * a[r][c]);
		calc(r, c + 1, cLimit, sum, totalSum);
	}

	static void comb(int cnt, int idx, int sum) {

		if (cnt == 2) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = idx; i < N * N; i++) {
			int x = i / N;// 행 row
			int y = i % N;// 열 col

			if (y > N - M) {
				continue;
			}

			max = 0;

			calc(x, y, y + M, 0, 0); // i, j+0, j+M, 양, 양*양

			comb(cnt + 1, i + M, sum + max);
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			a = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;

			comb(0, 0, 0);// 일꾼 0, 작업 위치 0, 채취양 0

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.print(sb.toString());

		br.close();
	}
}