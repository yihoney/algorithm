import java.io.*;

/**
 * f(0) = 1 0
 * f(1) = 0 1
 * f(2) = 1 1
 * f(3) = 1 2
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dp[][] = new int[41][2];
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			dp[0][0] = dp[1][1] = 1;
			dp[0][1] = dp[1][0] = 0;
			
			for(int n=2; n<=N; n++) {
				dp[n][0] = dp[n-2][0] + dp[n-1][0];
				dp[n][1] = dp[n-2][1] + dp[n-1][1];
			}
			
			sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
