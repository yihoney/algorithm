import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N = 0;
	static int M = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		solution(1, 0);
		System.out.println(sb);
	}

	private static void solution(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			solution(i + 1, cnt + 1);
		}

	}

}