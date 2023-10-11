import java.io.*;
import java.util.*;

public class Solution {
	static int N, B, ans;
	static int heights[];
	static boolean selected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			heights = new int[N];
			selected = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				heights[n] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int sum) {

		if (cnt == N) {
			if (sum >= B) {
				ans = Math.min(ans, sum - B);
			}
			return;
		}

		selected[cnt] = true;
		dfs(cnt + 1, sum + heights[cnt]);
		selected[cnt] = false;
		dfs(cnt + 1, sum);
	}
}