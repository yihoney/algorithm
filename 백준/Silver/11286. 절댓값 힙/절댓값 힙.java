import java.util.*;
import java.io.*;

/**
 * 
 * 절댓값 힙 -> 절댓값이 가장 작은 값 출력 후 배열에서 제거 
 * 1. 입력이 0이라면: 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거 
 * - 배열이 비어있는 경우 0 출력 제거 
 * 2. 입력이 0이 아니면: 배열에 입력 값 추가
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 우선순위 큐재정의
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> {
			if (Math.abs(e1) == Math.abs(e2)) { // 절댓값이 같다면
				return e1 < e2 ? -1 : 1; // 더 작은 수를 더 앞에 저장
			}
			return Math.abs(e1) - Math.abs(e2);
		});

		int N = Integer.parseInt(br.readLine()); // 연산의 개수

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine()); // 입력 받은 정수
			if (x == 0) { // 입력 받은 정수가 0일 때
				if (pq.isEmpty()) { // 비어있는 경우
					sb.append(0).append("\n"); // 0 출력
				} else { // 비어있지 않은 경우
					sb.append(pq.poll()).append("\n"); // 제거 후 출력
				}
			} else { // 입력 받은 정수가 0이 아니면
				pq.add(x); // 배열에 입력 값 추가
			}
		}

		System.out.println(sb);
	}
}