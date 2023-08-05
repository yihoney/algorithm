package com.ssafy.algo0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//class Person {
//	int cnt;
//	int candyN;
//
//	Person(int cnt, int candyN) {
//		this.cnt = cnt;
//		this.candyN = candyN;
//	}
//}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int candy = 20;
		int cnt = 0;
		
		while (true) {
			int candyN = Integer.parseInt(br.readLine());
			// cnt번째 사람이 n개의 마이쮸 가져감
			queue.add(++cnt); // cnt번째 사람이 줄을 섬
			candy -= candyN; // cnt번째 사람에게 마이쮸를 줌
			if(candy == 0) {
				break;
			}
			queue.add(queue.peek()); // 앞에 있던 사람이 다시 줄을 서고
			queue.poll(); // 원래 있던 앞에서 제거
		}

		System.out.println(queue.poll() + "번째 사람이 마지막 거 가져감");
	}
}
