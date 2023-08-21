import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치

		if (N == K) {
			System.out.println(0);
			System.exit(0);
		}

		int ans = 0;

		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[100001]; // 방문 배열

		queue.offer(N); // 초기 위치 우선 삽입
		isVisited[N] = true;
		int size = 0;

		while (true) {
			ans++;
			size = queue.size();

			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				isVisited[cur] = true;

				if ((cur - 1) == K || (cur + 1) == K || (2 * cur) == K) {
					System.out.println(ans);
					return;
				}

				if (cur - 1 >= 0 && !isVisited[cur - 1]) {
					queue.offer(cur - 1);
					isVisited[cur - 1] = true;
				}

				if (cur + 1 <= 100000 && !isVisited[cur + 1]) {
					queue.offer(cur + 1);
					isVisited[cur + 1] = true;
				}

				if (2 * cur <= 100000 && !isVisited[2 * cur]) {
					queue.offer(2 * cur);
					isVisited[2 * cur] = true;
				}
			}

		}

	}

}