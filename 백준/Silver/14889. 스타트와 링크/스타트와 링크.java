import java.util.*;
import java.io.*;

/**
 * 
 * BJ_14889_스타트와링크 
 * 
 * [ 코드 ]
 * 1. 입력 받기 
 * 2. 팀 짜기 
 * 	1. NCN/2 수행하는 comb()
 *  2. 스타트 팀과 링크 팀을 선택 여부로 가르기 위해 boolean 타입 배열 생성해서 뽑았다면 true로 변경 
 *  3. 멤버를 다 뽑았다면 팀 간 능력치 차이를 구하는 메서드 호출 
 * 3. 능력치 차이 구하기 
 *  1. 첫번째 반복문은 인덱스 0부터 N-2까지, 두번째 반복문은 인덱스 첫번째반복문인덱스+1부터 N-2까지 돌게 함
 *  2. 두 반복문의 인덱스에 해당하는 선택 여부 배열값이 모두 true라면 스타트 팀 능력치에 더해줌 
 *  3. 두 반복문의 인덱스에 해당하는 선택 여부 배열값이 모두 false라면 스타트 팀 능력치에 더해줌 
 * 4. 정답 출력 
 *  1. 두 팀의 능력치 차가 0이라면 어차피 최소이므로 0 출력 후 종료 
 *  2. 두 팀의 능력치 차가 0이 아니라면 기존의 최솟값과 비교해 최솟값 저장 
 *  
 * @author yihoney
 */

public class Main {
	static int arr[][];
	static boolean[] selected;
	static int N, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 1.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 축구를 하기 위해 모인 사람 총 N명
		arr = new int[N][N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 2.
		comb(0, 0);
		System.out.println(ans);
	}

	// 2-1
	private static void comb(int start, int cnt) {
		// 2-3
		if (cnt == N / 2) {
			calculateDiff();
			return;
		}
		
		for (int i = start; i < N; i++) {
			// 2-2
			selected[i] = true;
			comb(i + 1, cnt + 1);
			selected[i] = false;
		}
	}

	// 3.
	private static void calculateDiff() {
		int startSum = 0;
		int linkSum = 0;

		// 3-1
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// 3-2
				if (selected[i] && selected[j]) {
					startSum += (arr[i][j] + arr[j][i]);
				}
				// 3-3
				if (!selected[i] && !selected[j]) {
					linkSum += (arr[i][j] + arr[j][i]);
				}
			}
		}

		int diff = Math.abs(startSum - linkSum);

		// 4-1
		if (diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}

		// 4-2
		ans = Math.min(ans, diff);
	}

}