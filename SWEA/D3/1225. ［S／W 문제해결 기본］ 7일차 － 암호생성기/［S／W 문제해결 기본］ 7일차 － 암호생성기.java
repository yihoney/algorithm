import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10; // 테스트 반복 회수는 10으로 고정
		int dataN = 8; // 데이터 갯수는 8로 고정
		Queue<Integer> queue = new LinkedList<>();
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < dataN; i++) { // 큐 안에 입력 받은 숫자 add
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int cnt = 1;
			while (cnt <= 5) {
				int num = queue.poll() - cnt++; // 맨 앞에 있는 숫자 - cnt
				if (num <= 0) { // 0보다 작아지는 경우
					queue.add(0); // 0을 넣고
					break; // 반복문 탈출
				}
				queue.add(num); // 연산한 값 맨 뒤로 보냄
				if (cnt == 6) {
					cnt = 1;
				}
			}
			// 큐 안에 있는 숫자 출력
			System.out.printf("#%d", n);
			while (!queue.isEmpty()) {
				System.out.printf(" %d", queue.poll());
			}
			System.out.println();
		}
	}
}
