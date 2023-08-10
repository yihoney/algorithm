import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static int[] arr;
	static int[] ans;
	static final int n = 7, totalN = 9;
	static StringBuilder sb = new StringBuilder();
	static boolean printFlag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[totalN];
		ans = new int[n];
		for (int i = 0; i < totalN; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0);
		System.out.println(sb);
	}

	public static void combination(int cnt, int startIdx) {
		if (cnt == n) {
			if(printFlag) {
				return;
			}
			int sum = IntStream.of(ans).sum();
			if (sum == 100) {
				Arrays.sort(ans);
				for (int i = 0; i < n; i++) {
					sb.append(ans[i]).append("\n");
				}
				printFlag = true;
			}
			return;
		}

		for (int i = startIdx; i < totalN; i++) {
			ans[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}
}