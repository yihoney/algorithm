import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		solution(0, 0, N);
		System.out.println(sb);
	}

	private static void solution(int r, int c, int size) {

		int sum = 0;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += arr[i][j];
			}
		}

		if (sum == 0) {
			sb.append(0);
		} else if (sum == size * size) {
			sb.append(1);
		} else {
			int half = size / 2;
			sb.append("(");
			solution(r, c, half);
			solution(r, c + half, half);
			solution(r + half, c, half);
			solution(r + half, c + half, half);
			sb.append(")");
		}

	}
}
