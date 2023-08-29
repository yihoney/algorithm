import java.io.*;
import java.util.*;

/**
 * BJ 1149 RGB거
 * 
 * 이해가 안 가서 다른 사람의 코드를 참조하였다. ㅜㅜ
 * 
 * 모든 경로의 경우의 수를 찾아 최종적으로 작은 누적합을 찾아야 함!
 * 
 * [점화식] 
 * - 빨: cost[n][0] = cost[n][0]+Math.min(cost[n-1][1], cost[n-1][2]); 
 * - 초: cost[n][1] = cost[n][1]+Math.min(cost[n-1][0], cost[n-1][2]); 
 * - 파: cost[n][2] = cost[n][2]+Math.min(cost[n-1][0], cost[n-1][1]);
 * 
 * @author 이하늬
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N][3]; // 메모이제이

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 1부터 N-1까지 각 숫자별로 다른 색상 중에 최솟값을 누적하며 더하
		for (int n = 1; n < N; n++) {
			cost[n][0] = cost[n][0] + Math.min(cost[n - 1][1], cost[n - 1][2]);
			cost[n][1] = cost[n][1] + Math.min(cost[n - 1][0], cost[n - 1][2]);
			cost[n][2] = cost[n][2] + Math.min(cost[n - 1][0], cost[n - 1][1]);
		}
		
		// 정답 출력 
		System.out.println(Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]));
	}
}
