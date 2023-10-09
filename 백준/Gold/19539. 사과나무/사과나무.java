/**
 * <pre>
 * 
 * BJ_19539_사과나무 
 *
 * 그리디 문제
 * 
 * 1. 나무가 자라나는 데 걸리는 총 일수 = 전체 나무의 높이들을 더한 값 / 3
 * 2. 2만큼 성장시킬 수 있는 물뿌리개를 사용할 수 있는 횟수 >= 나무가 자라나는 데 걸리는 총 일수
 * -> 2번을 만족하지 않으면 1만큼 자라나는 물뿌리개를 더 많이 사용해야한다는 뜻 
 * 
 * 와우.. 어려움 아직 그리디 넘 어렵다 
 * 
 * 
 * @author yihoney
 * </pre>
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int heights[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int cnt = 0; // 2로 뿌릴 수 있는 횟수
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
			sum += heights[i];
			cnt += heights[i] / 2;
		}

		if (sum % 3 != 0) {
			System.out.println("NO");
		}

		if (sum % 3 == 0) {
			sum /= 3; // 3으로 뿌릴 수 있는 횟수
			if (cnt >= sum) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
