import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 피보나치 수 미리 계산해두기
		int dp[] = new int[45];
		dp[0] = 0;
		dp[1] = 1;
		for (int n = 2; n < 45; n++) {
			dp[n] = dp[n - 2] + dp[n - 1];
		}

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int ans[] = new int[45];
			int cnt = 0;
			for (int n = 44; n >= 0; n--) {
				if (N == 0) {
					break;
				}
				if (dp[n] <= N) {
					ans[cnt++] = dp[n];
					N -= dp[n];
				}
			}
			for (int n = 1; n <= cnt; n++) {
				sb.append(ans[cnt - n]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
