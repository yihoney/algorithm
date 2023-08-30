import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ 1010 다리 놓기
 * 
 * 
 * @author 이하늬
 *
 *         메모리 KB 시간 ms
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 서쪽에 있는 사이트의 개수
			int M = Integer.parseInt(st.nextToken()); // 동쪽에 있는 사이트의 개수

			int[][] arr = new int[M + 1][N + 1];
			
			for (int i = 0; i <= M; i++) {
				for (int j = 0, end = Math.min(i, N); j <= end; j++) {

					if (j == 0 || i == j) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}
			
			sb.append(arr[M][N]).append("\n");
		}
		
		System.out.println(sb);
	}

}