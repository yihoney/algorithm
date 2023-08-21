import java.io.*;

/**
 * 
 * BJ 10026 적록색약
 * 
 * 이 방식을 flood fill 이라 한다고 한다..!
 * 
 * 적록색약인 사람은 빨강-초록을 구분하지 못하므로 초록색일 경우 빨간색으로 그림 색을 바꿔주면
 * 같은 로직으로 구역의 수를 판단 가능!!
 * 
 * 메모리 12848KB
 * 시간 88ms
 *
 */

public class Main {
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int ans1 = 0, ans2 = 0; // 적록색약이 아닌 사람이 본 구역 수, 적록색약이 본 구역 수
	static char[][] arr1, arr2; // 적록색약이 아닌 사람이 본 그림과 적록색약이 본 그림
	static boolean[][] isVisited1, isVisited2; // 적록색약이 아닌 사람이 본 방문배열, 적록색약 방문배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		// 방문배열 만들기
		isVisited1 = new boolean[N + 2][N + 2];
		isVisited2 = new boolean[N + 2][N + 2];
		// 배열 범위 체크하기 간편하게 테두리 감싸주기 !!
		arr1 = new char[N + 2][N + 2]; 
		arr2 = new char[N + 2][N + 2];
		
		//
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				arr1[i][j] = str.charAt(j-1);
				if (str.charAt(j-1) == 'G') { // 초록색일 경우
					arr2[i][j] = 'R'; // 적록색약 그림은 빨간색으로 채워넣기
				} else { // 초록색이 아니면
					arr2[i][j] = str.charAt(j-1); // 원본 그림으로 채워넣기
				}
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				// 적록색약이 아닌 사람
				if (!isVisited1[r][c]) { // 아직 방문하지 않았다면
					dfs(isVisited1, arr1, r, c); // 적록색약이 아닌 사람의 방문 배열과 그림을 넘겨줌
					ans1++;
				}
				// 적록색약인 사람
				if (!isVisited2[r][c]) { // 아직 방문하지 않았다면
					dfs(isVisited2, arr2, r, c); // 적록색약인 사람의 방문 배열과 그림을 넘겨줌
					ans2++;
				}
			}
		}

		// 적록색약이 아닌 사람과 적록색약이 본 그림의 구역 수를 차례대로 출력
		System.out.println(ans1 + " " + ans2);

	}

	
	/**
	 * 구역의 수를 판단하는 dfs 메서드
	 * 
	 * @param isVisited 방문플래그 배열
	 * @param arr 그림
	 * @param cx 현재 x 좌표
	 * @param cy 현재 y 좌표
	 */
	public static void dfs(boolean[][] isVisited, char[][] arr, int cx, int cy) {

		isVisited[cx][cy] = true; // 우선 방문 했으니까 플래그 true로 변경
		int nx, ny; // 탐색할 좌표
		for (int d = 0; d < dirs.length; d++) {
			nx = cx + dirs[d][0]; // 현재 x좌표에 방향벡터값 더해줌
			ny = cy + dirs[d][1]; // 현재 y좌표에 방향벡터값 더해줌

			// 이동할 좌표가 배열 범위 안이고 아직 방문하지 않았고 기준 좌표와 이동할 좌표 색이 같을 경우에만
			if (arr[nx][ny] != 0 && !isVisited[nx][ny] && (arr[cx][cy] == arr[nx][ny])) {
				dfs(isVisited, arr, nx, ny); // 다음 좌표를 넘겨 dfs 호출
			}
		}

	}

}