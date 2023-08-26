import java.util.*;
import java.io.*;

/**
 * SWEA 1767 프로세서 연결하기
 * 
 * 가장자리에는 전원이 흐르고 있어 이미 전원 연결된 것으로 간주 (전선 연결할 필요 X) Core와 전원을 연결하는 전선은 직선만 가능 전선
 * 교차 불가능
 * 
 * => 최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합은? (전선 길이의 합은 최소)
 * 
 * @author 이하늬
 */

class Core {
	int x, y;

	Core(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static List<Core> cores;
	static int ans, maxCoreCnt, minWireLen;
	static int cell[][];
	static int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌,
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			// 입력 받기
			int N = Integer.parseInt(br.readLine()); // 멕시노스 크기
			cores = new ArrayList<>(); // 코어들을 저장해둘 리스
			cell = new int[N + 2][N + 2]; // cell
			for (int i = 0; i < N + 2; i++) {
				Arrays.fill(cell[i], -1); // cell의 모든 값 -1로 초기
			}

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if (cell[i][j] == 1) { // 코어 라면 코어 리스트에 추가
						if (i == 1 || j == 1 || i == N || j == N) { // 하지만 가장자리에 있는 코어라면 고려할 필요 없으므로
							continue; // 추가 과정 생략
						}
						cores.add(new Core(i, j)); // 코어리스트에코어 추
					}
				}
			}

			// 최소 한번은 변경되어야 하므로 최댓값은 최소로, 최솟값은 최대로 초기
			maxCoreCnt = Integer.MIN_VALUE;
			minWireLen = Integer.MAX_VALUE;
			connectCore(0, 0, 0);
			ans = minWireLen;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * 코어를 연결하는 메서드
	 * 
	 * @param n 연결할 코어 (코어리스트에서의 코어 인덱스) 
	 * @param coreCnt 연결한 코어 갯수 
	 * @param wireLen 연결한 전선 길이 
	 */
	public static void connectCore(int n, int coreCnt, int wireLen) {
		// 기저조
		if (n == cores.size()) { // 모든 코어를 고려했다면
			if (maxCoreCnt < coreCnt) { // maxCoreCnt보다 현재 coreCnt가 더 크다
				maxCoreCnt = coreCnt; // 최대한 만은 Core을 연결해야하므로 최댓값 변경해주
				minWireLen = wireLen; // 전선 연결 수도 변경해줌
			} else if (maxCoreCnt == coreCnt) { // 연결한 코어 갯수가 같다면
				minWireLen = Math.min(minWireLen, wireLen); // 전선 길이는 최소값으로 저장해주기
			}
			return;
		}

		// 코어의 시작 좌표
		int cx = cores.get(n).x;
		int cy = cores.get(n).y;

		for (int d = 0; d < dirs.length; d++) {
			int nx = cx, ny = cy, len = 0;

			while (true) {
				nx += dirs[d][0];
				ny += dirs[d][1];

				if (cell[nx][ny] == -1) { // 범위를 벗어나면 이 방향은 탐색 종료 -> 전원 연결 완료!
					break;
				}

				if (cell[nx][ny] == 1) { // 다른 코어나 전선을 만난다면 연결 종료 -> 전원 연결 불가능!
					len = 0; // 전선 길이 초기화
					break;
				}
				// 여기까지 왔다면 전선을 놓을 수 있으므로 길이 + 1
				len++;
			}

			if (len == 0) { // 전선 길이가 0이라면 연결하지 못했으므로 다음 코어 연결 (연결한 코어와 전선 길이 그대로 넘겨줌)
				connectCore(n + 1, coreCnt, wireLen);
			} else { // 전선 길이가 0이 아닐 경우 연결한 것이므로 연결한 코어 갯수+1, 전선 길이+이번에 연결한 전선 길이 넘겨줌
				// 전선 연결 시작
				// 시작 좌표 초기화
				nx = cx;
				ny = cy;
				connectWire(d, nx, ny, len, true); // 전선 연결해주기
				connectCore(n + 1, coreCnt + 1, wireLen + len);
				connectWire(d, nx, ny, len, false); // 연결 했던 전선 처음 상태로 되돌리기
			}
		}

	}

	/**
	 * cell에 전선을 연결하는 메서드
	 * 
	 * @param d    연결할 방향
	 * @param nx   연결할 다음 x 좌표
	 * @param ny   연결할 다음 y 좌표
	 * @param len  연결할 전선 길이
	 * @param flag true면 1로 채우고, false이면 0으로 채움
	 */
	private static void connectWire(int d, int nx, int ny, int len, boolean flag) {
		int fillN = 1;
		if (!flag) {
			fillN = 0;
		}

		for (int i = 0; i < len; i++) {
			nx += dirs[d][0];
			ny += dirs[d][1];
			cell[nx][ny] = fillN;
		}
	}
}