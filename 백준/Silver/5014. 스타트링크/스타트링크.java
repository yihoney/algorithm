import java.util.*;
import java.io.*;

/**
 * BJ 5014 스타트링크
 * 
 * 다음 이동할 층을 계산하여 범위를 벗어나는지와 이미 방문한 층인지 체크하여 BFS 이용해 해결 
 * 층을 이동할 때마다 누적 기존 층까지 이동하기 위해 버튼을 누른 횟수 + 1을 저장해줌 
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 총 F층 (가장 높은 층)
		int S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 층
		int G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 곳의 위치
		int U = Integer.parseInt(st.nextToken()); // 위로 U층을 가는 버튼
		int D = Integer.parseInt(st.nextToken()); // 아래로 D층을 가는 버튼

		int[] visitedCnt = new int[F + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		visitedCnt[S] = 1; // 방문 횟수 1로 설정

		while (!q.isEmpty()) {
			int cur = q.poll(); // 현재 층

			if (cur == G) { // 목표층에 도착했다면 반복문 탈출
				break;
			}

			// 가야될 층 계산
			int up = cur + U; // 위층
			int down = cur - D; // 아래층

			if (up <= F && visitedCnt[up] == 0) {
				visitedCnt[up] = visitedCnt[cur] + 1; // 기존 층의 누적 버튼 횟수 + 1을 저장
				q.offer(up);
			}
			if (down >= 1 && visitedCnt[down] == 0) {
				visitedCnt[down] = visitedCnt[cur] + 1; // 기존 층의 누적 버튼 횟수 + 1을 저장
				q.offer(down);
			}

		}

		if (visitedCnt[G] == 0) { // G층까지 올라가기 위해 눌러야 하는 버튼 횟수가 0이라 엘베로 이동 불가
			System.out.println("use the stairs");
		} else {
			System.out.println(visitedCnt[G] - 1); // 처음에 누른 버튼 횟수 1 빼주기 
		}
	}

}