import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(t).append(" ");
			solution();
			
		}
		System.out.println(sb.toString());

	}

	private static void solution() {
		int[] len = new int[arr.length];
		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			len[i] = 1;
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] < arr[i] && len[i] < len[j] + 1) {
					len[i] = len[j] + 1;
				}
			}
			maxLen = Math.max(maxLen, len[i]);
		}
		sb.append(maxLen).append("\n");

	}
}