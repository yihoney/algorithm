import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				map[r][c] += Math.max(map[r - 1][c - 1], Math.max(map[r - 1][c], map[r][c - 1]));
			}
		}

		System.out.println(map[N][M]);
	}
}
