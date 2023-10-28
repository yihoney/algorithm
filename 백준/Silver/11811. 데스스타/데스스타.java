import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * mij = ai & aj
 * ai = ai | mij
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 행렬의 크기 N

		for (int i = 0; i < N; i++) {
			int n = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int m = Integer.parseInt(st.nextToken());
				if (i == j) {
					continue;
				}
				n |= m;
			}
			System.out.print(n + " ");
		}

	}
}
