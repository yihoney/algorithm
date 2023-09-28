import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BJ_2239_스도쿠
 * 
 * 잘 푼 스도쿠가 되는 법 ! 
 * 1. 각 행에 1~9 숫자가 중복 없이 나옴 
 * 2. 각 열에 1~9 숫자가 중복 없이 나옴 
 * 3. 각 3*3 사각형에 1~9 숫자가 중복 없이 나옴
 * 
 * @author 이하늬
 */

public class Main {
	static int arr[][];
	static List<int[]> blankList;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		blankList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
				if (arr[i][j] == 0) { // 채워야 되는 칸이면 blankList에 추가
					blankList.add(new int[] { i, j });
				}
			}
		}
		// 첫번째 빈칸부터 채우러 가보기
		solution(0);
	}

	private static void solution(int cnt) {

		if (cnt == blankList.size()) {
			// 모든 칸을 다 채웠다면 출력 후 종료
			printAns();
			System.exit(0);
		}

		boolean numbers[] = new boolean[10]; // 해당 범위에 존재하는 숫자를 체크할 숫자 배열
		int[] cur = blankList.get(cnt);
		int r = cur[0];
		int c = cur[1];

		// 해당 행에 있는 숫자 체크하기
		checkRow(r, numbers);
		// 해당 열에 있는 숫자 체크하기
		checkCol(c, numbers);
		// 해당 박스에 있는 숫자 체크하기
		checkBox(r, c, numbers);

		// 존재하지 않는 숫자를 체크해서 solution메서드 재귀 호출
		for (int n = 1; n <= 9; n++) {
			if (!numbers[n]) {
				arr[r][c] = n; // =1;
				solution(cnt + 1); // (2)
				arr[r][c] = 0;
			}
		}

	}

	// 1.
	private static void checkRow(int r, boolean[] numbers) {
		for (int c = 0; c < 9; c++) {
			if (arr[r][c] != 0) {
				numbers[arr[r][c]] = true;
			}
		}
	}

	// 2.
	private static void checkCol(int c, boolean[] numbers) {
		for (int r = 0; r < 9; r++) {
			if (arr[r][c] != 0) {
				numbers[arr[r][c]] = true;
			}
		}
	}

	// 3.
	private static void checkBox(int r, int c, boolean[] numbers) {

		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;

		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (arr[i][j] != 0) {
					numbers[arr[i][j]] = true;
				}
			}
		}
	}

	private static void printAns() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}