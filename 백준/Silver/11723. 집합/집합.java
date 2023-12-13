import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine()); // 수행해야 하는 연산의 수 M
		int S = 0; // 비트마스킹

		while (M-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {

			case "all": // S를 {1, 2, ..., 20} 으로 바꿈
				S = (1 << 20) - 1;
				break;

			case "empty": // S를 공집합으로 바꿈
				S = 0;
				break;

			default:
				int x = Integer.parseInt(st.nextToken());
				switch (command) {
				case "add": // S에 x를 추가
					S |= (1 << (x - 1));
					break;

				case "remove": // S에서 x를 제거
					S &= ~(1 << (x - 1));
					break;

				case "check": // x가 있으면 1 출력, x가 없으면 0 출력
					sb.append((S & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
					break;

				case "toggle": // x가 있으면 x를 제거, x가 없으면 x를 추가
					S ^= (1 << (x - 1));
					break;
				}
			}
		}
		System.out.println(sb);

	}
}