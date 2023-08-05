package ssafy.hw0804;

/**
 * 백준 2164 카드2
 * 
 * N장의 카드가 주어졌을 때,
 * 1. 제일 위에 있는 카드 버림
 * 2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
 * 을 반복한다.
 * 
 * => 선입선출구조인 Queue 이용
 * 따라서, 1부터 N까지 우선 Queue에 집어넣고,
 * < 맨 앞의 카드를 버리고 -> queue.poll()
 * 	 맨 위에 있는 카드를(queue.peek()) 제일 뒤로 옮기고 -> queue.add()
 * 	 맨 앞에 있는 카드를 버려준다. -> queue.poll() >
 * 과정을 큐에 카드가 1장이 남을 때까지 반복 수행 해줬다.
 * 1장이 남았을 때 해당 카드가 제일 마지막에 남는 카드!
 * 
 * 메모리: 45512 KB, 시간: 204ms
 * 
 * @author 이하늬
 * 
 */

import java.io.*;
import java.util.*;

public class BJ_2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			queue.add(n);
		}

		while (queue.size() != 1) { // 큐에 남아있는 카드가 1장이 아니라면 반복문 수행
			queue.poll(); // 맨 앞의 카드를 버림
			queue.add(queue.peek()); // 맨 위에 있는 카드를 제일 뒤로 옮기고
			queue.poll(); // 맨 앞에 있는 카드를 버림
		}
		System.out.println(queue.peek()); // 마지막 남은 카드의 숫자 출력
	}
}
