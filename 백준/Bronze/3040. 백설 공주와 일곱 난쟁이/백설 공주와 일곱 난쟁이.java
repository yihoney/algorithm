import java.io.*;
import java.util.stream.*;

public class Main {
	static int[] arr;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		ans = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combi(0,0);
		System.out.println(sb);
	}

	private static void combi(int start, int cnt) {
		if (cnt == 7) {
			if (IntStream.of(ans).sum() == 100) {
				if (flag) {
					return;
				}
				for (int i = 0; i < ans.length; i++) {
					sb.append(ans[i]).append("\n");
					flag = true;
				}
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			ans[cnt] = arr[i];
			combi(i + 1, cnt + 1);
		}

	}
}
