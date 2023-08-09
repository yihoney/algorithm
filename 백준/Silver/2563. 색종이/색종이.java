import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		StringTokenizer st;

		boolean flag[][] = new boolean[100][100];

		int x; // 입력 받은 x좌표를 저장할 변수
		int y; // 입력 받은 y좌표를 저장할 변수
		int cnt = 0; // 겹치는 영역 count 해서 저장할 변수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // x좌표
			y = Integer.parseInt(st.nextToken()); // y좌표

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (flag[j][k] == false) { // 한 번도 방문하지 않은 좌표라면
						flag[j][k] = true; // 플래그를 true로 변경
					} else if (flag[j][k] == true) { // 이미 한 번 체크 된 좌표이기 때문에 겹치는 영역임
						cnt++; // count + 1 해줌
					}
				}
			}
		}

		System.out.println(N * 10 * 10 - cnt);
	}
}