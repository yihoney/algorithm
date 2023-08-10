import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static final int cardN = 9; // 한 사람이 가지는 카드 갯수
	static int winCntG, winCntI;
	static int arrG[], arrI[];
	static boolean isSelected[];
	static int curCardArr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arrG = new int[cardN]; // 규영이 카드들
															
		arrI = new int[9]; // 인영이 카드들
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {
			boolean cardFlag[] = new boolean[cardN * 2 + 1]; // 18개의 카드 중 이미 나눠준 카드를 체크하는 플래그 배열 (편의를 위해 숫자대로 인덱스 부여 위해  카드갯수+1)
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());

			// 규영이 카드 나눠주기
			for (int i = 0; i < cardN; i++) {
				arrG[i] = Integer.parseInt(st.nextToken());
				cardFlag[arrG[i]] = true; // 규영이에게 이미 나눠준 카드의 숫자는 카드 플래그 값을 true로 변경
			}

			// 인영이에게 규영이가 받은 카드 빼고 나눠주기
			int idx = 0;
			for (int i = 1; i < cardFlag.length; i++) {
				if (!cardFlag[i]) { // 플래그가 false인 숫자만 인영이에게 나눠주기
					arrI[idx++] = i; // 인영이 카드 배열에 카드플래그 인덱스(카드에 적혀진 숫자) 저장
				}
			}

			winCntG = 0; // 규영이가 이긴 횟수
			winCntI = 0; // 인영이가 이긴 횟수
			isSelected = new boolean[cardN];
			curCardArr = new int[cardN];
			playGame(0);
			sb.append(winCntG).append(" ").append(winCntI).append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * 
	 * @param cnt 지금까지 뽑은 인영이 카드 갯수
	 */
	private static void playGame(int cnt) {
		if (cnt == cardN) { // 인영이 카드 9장이 다 결정된 경우!
			int pointG = 0;
			int pointI = 0;
			for (int i = 0; i < cardN; i++) { // 카드를 한장씩 비교해주기 위해 cardN회 만큼 반복
				if (arrG[i] > curCardArr[i]) { // 만약 기영이 카드에 적힌 숫자가 인영이 카드에 적힌 숫자보다 더 크면
					pointG += arrG[i] + curCardArr[i]; // 기영이 포인트에 기영이 카드에 적힌 숫자+인영이 카드 숫자 더해줌
				} else { // 인영이 카드에 적힌 숫자가 기영이 카드에 적힌 숫자보다 더 크면
					pointI += curCardArr[i] + arrG[i]; // 인영이 포인트에 인영이 카드에 적힌 숫자+기영이 카드 숫자 더해줌
				}
			}
			if (pointG > pointI) { // 기영이 누적 포인트가 더 크면 기영이 승!
				winCntG++;
			} else if (pointI > pointG) { // 인영이 누적 포인트가 더 크면 인영이 승!
				winCntI++;
			} // else 무승부 -> 아무 일도 안 일어남
			return;
		}

		for (int i = 0; i < cardN; i++) {
			if (isSelected[i]) { // 중복 체크를 위해 이미 선택된 카드라면 패스
				continue;
			}
			// 현재 인영이의 카드는 인영이가 뽑을 수 있는 카드 중 i번째 카드
			curCardArr[cnt] = arrI[i];
			isSelected[i] = true; // i번째 카드 선택 플래그 true로 변경
			// 다음 카드 뽑기
			playGame(cnt + 1);
			// 현재 인영이의 카드를 i번째 카드 말고 다른 카드로 뽑기 위해 false로 변경
			isSelected[i] = false;
		}

	}

}
