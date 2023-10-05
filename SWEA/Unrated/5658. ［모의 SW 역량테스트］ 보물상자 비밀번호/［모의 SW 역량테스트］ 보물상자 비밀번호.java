import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static char[] input;
	static TreeSet<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			input = str.toCharArray();

			generateKey();


			// 내림차순으로 정렬
			Iterator<Integer> it = set.descendingIterator();

			for(int i=1; i<=K-1; i++) {
//				System.out.print(it.next()+" ");
				it.next();
			}
			ans = (int) it.next();

			sb.append("#").append(t).append(" ");
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void generateKey() {

		String str = null;
		set = new TreeSet<>();

		int splitN = N / 4;

		for (int r = 0; r < splitN; r++) {

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < N; i++) {
				builder.append(input[i]);
			}

			str = builder.toString();

			for (int i = 0; i < N; i += splitN) {
				String s = str.substring(i, i + splitN);
				int n = Integer.parseInt(s.toString(), 16);
				set.add(n);
			}

			// 회전
			char tmp = input[N - 1];
			for (int i = N - 1; i > 0; i--) {
				input[i] = input[i - 1];
			}
			input[0] = tmp;

		}
	}
}