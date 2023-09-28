import java.io.*;
import java.util.*;

/**
 *BJ_3190_뱀
 *
 * - 뱀은 매초마다 이동 
 * - 사과를 먹으면 뱀 길이가 늘어나고, 벽 또는 자기자신의 몸과 부딪히면 게임 끝
 * - 뱀의 시작 위치: (1,1) / 초기 길이: 1 / 방향: 오른쪽을 향함 
 * - 뱀 이동 순서
 * 	1. 머리를 다음칸에 위치시킴
 * 	2. 이동
 * 		- 이동한 칸에 사과 O: 사과 없어지고 꼬리 움직이지 않음
 * 		- 이동한 칸에 사과 X: 꼬리가 위치한 칸을 비워줌 (머리만 우선 이동했고 길이는 늘어나지 않으므로 꼬리를 지움)
 * 
 * [ 코드 ]
 * 1. 입력받기
 * 	 1. 사과가 있는 곳에 1 저장해서 사과가 있음을 표시 
 * 	 2. 방향 변환 정보는 Map에 키를 방향 변환할 시간, 값을 변환할 방향으로 해서 저장 
 * 2. 뱀 이동하기 
 * 	- 무한루프를 돌며
 * 		1. 현재 위치 + 방향벡터배열[현재 방향] 으로 다음 좌표 계산
 * 		2. 다음 좌표가 벽이거나 자신의 몸과 부딪히면(큐에 이동할 위치가 이미 포함되어 있다면) 게임 종료 
 * 		3. 이동할 수 있다면 큐에 x좌표*배열크기+y좌표 삽입
 * 		4. 이동한 곳에 사과가 있다면 사과 먹어서 없애준 후 진행 
 * 		   			사과가 없다면 꼬리 위치한 좌표를 지워줌 (큐에서 삭제) 
 * 		5. 방향을 전환해야 된다면 (방향벡터: 상우하좌)
 * 		   C가 L일 경우 방향벡터 - 1
 * 		   C가 D일 경우 방향벡터 + 1
 * 		
 * 
 * @author yihoney
 */


public class Main {
	static int N;
	static int[][] map;
	static Map<Integer, Character> directions;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 1.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 보드 크기 N
		map = new int[N + 2][N + 2]; // 벽 포함해서 배열의 크기는 N+2 * N+2
		
		// 1-1
		int K = Integer.parseInt(br.readLine()); // 사과 개수 K
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine()); // 사과의 위치
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1; // 사과가 있는 곳에 1 저장
		}
		
		// 1-2
		int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수 L
		directions = new HashMap<>(); // 방향 변환 정보를 저장해둘 배열
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine()); // 사과의 위치
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			directions.put(x, c); // 키: x, 값: c
		}

		go();
	}

	private static void go() {
		Queue<Integer> queue = new LinkedList<>();

		int cd = 1; // 초기 위치: (0,0) , 방향: 오른쪽(방향벡터 인덱스 1)
		int cx = 1;
		int cy = 1;

		int t = 0; // 경과 시간
		
		queue.offer(cx * N + cy); // 뱀이 좌표 위에 위치해 있음을 표시

		while (true) {
			// 2-1
			t++; // 시간 증가

			int nx = cx + dirs[cd][0];
			int ny = cy + dirs[cd][1];

			if(!isValid(queue, t, nx, ny)) {
				System.out.println(t); // 경과시간 출력
				break;
			}

			// 2-3
			queue.offer(nx * N + ny);
			// 2-4
			if (map[nx][ny] == 1) { // 사과가 있다면
				map[nx][ny] = 0; // 사과 없앰 
			} else { // 사과가 없다면
				queue.poll(); // 꼬리 삭제
			}

			map[nx][ny] = 2; // 우선 머리부터 이동

			// 2-5
			if (directions.containsKey(t)) { // 방향 전환 해야되는 시간이면
				Character direction = directions.get(t);
				if (direction == 'L') { // 왼쪽
					if (cd == 0) {
						cd = 3;
					} else {
						cd -= 1;
					}
				}

				if (direction == 'D') { // 오른쪽
					if (cd == 3) {
						cd = 0;
					} else {
						cd += 1;
					}
				}
			}
			cx = nx;
			cy = ny;
		}
		
		
	}

	// 2-2
	private static boolean isValid(Queue<Integer> queue, int t, int nx, int ny) {
		if (nx < 1 || nx > N || ny < 1 || ny > N) { // 이동할 위치가 범위 안에 있지 않으면 종료 
			return false;
		}

		if (queue.contains(nx * N + ny)) { // 자기 몸통에 부딪히면 종료 
			return false;
		}
		
		return true;
	}


}