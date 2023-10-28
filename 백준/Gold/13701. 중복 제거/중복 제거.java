import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * 입력될 수 있는 최댓값은 2^25
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		BitSet bitset = new BitSet(1 << 25);

		while (st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());

			if (!bitset.get(n)) {
				bitset.set(n);
				sb.append(n + " ");
			}
		}

		System.out.println(sb);
	}
}
