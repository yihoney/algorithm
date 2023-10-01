import java.io.*;
import java.util.*;

/**
 * BJ_21608_상어초등학교
 * 
 * - 한 칸에는 학생 한 명의 자리만 있을 수 있음 
 * - |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸이 (r1, c1)과 (r2, c2)를 인접하다고 함 -> 4방 탐색 
 * 
 * [ 코드 ]
 * 1. 입력 받기
 *  1. 크기가 N*N인 배열에 학생 순서를 저장할 배열 생성 
 *  2. 학생마다 좋아하는 학생을 저장할 Map 생성 (키: 기준학생번호, 값: Set<좋아하는학생번호>)
 *  
 * 2. 자리 정하기 
 *  1. 배열 첫번째 인덱스 부터 자리 선정 우선순위대로 자리 선정 
 *  2. 자리 선정 우선순위 => 우선순위를 쉽게 비교할 수 있도록 Seat라는 클래스 생성 후 Comparable 상속 
 * 	  1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸 (내림차순 이므로 뺀 값에 -1 곱해줌) 
 * 		-> 4방 탐색 후 가능한 자리 좌표와 인접한 칸 갯수 배열에 저장 
 *    2. 인접한 칸 중 비어있는 칸이 가장 많은 칸  (내림차순 이므로 뺀 값에 -1 곱해줌)
 *    3. 행의 번호가 가장 작은 칸
 *    4. 열의 번호가 가장 작은 칸 
 *  3. 이미 자리가 정해진 경우는 자리 선정 생략 
 *  4. 4방 탐색하며 계산한 좌표 값이 배열 범위를 벗어나면 다음 과정 생략 
 *  5. 4방 탐색하며 계산한 좌표 0이라면 아직 비어있는 자리이므로 비어있는칸Cnt ++ 해줌 
 *  6. 4방 탐색하며 계산한 좌표의 학생 번호를 studentNum의 좋아하는 학생 Set에 포함하고 있다면 인접좋아하는학생Cnt++ 해줌 
 *  7. 계산한 비어있는칸 수, 인접한 칸의 좋아하는 학생 수를 기반으로 Seat 인스턴스 생성 
 *  8. 아직 자리가 정해지지 않았다면 생성한 Seat 인스턴스를 저장해주고, 
 *     이미 자기라 정해졌다면 새로 만든 Seat 인스턴스와 비교해 우선순위대로 자리를 재설정해줌 
 * 3. 만족도 총 합 구하기 
 *  1. 정해진 자리들을 기반으로 해당 자리의 인접한 칸에 앉은 좋아하는 학생 수 구하기 
 *  2. 학생 수가 0이면 학생의 만족도는 0이므로, 0보다 큰 경우에만
 *  	10^(학생수-1)을 계산해 만족도 총 합에 더해줌
 * 
 * @author yihoney
 */

class Seat implements Comparable<Seat> {
	int x, y, studentNum, likeStdCnt, adjoinEmptyCnt;

	Seat(int x, int y, int likeStdCnt, int adjoinEmptyCnt) {
		this.x = x;
		this.y = y;
		this.likeStdCnt = likeStdCnt;
		this.adjoinEmptyCnt = adjoinEmptyCnt;
	}

	// 2-2
	@Override
	public int compareTo(Seat s) {
		// 2-2 (1)
		if (likeStdCnt != s.likeStdCnt) {
			return (likeStdCnt - s.likeStdCnt) * -1;
		}
		// 2-2 (2)
		if (adjoinEmptyCnt != s.adjoinEmptyCnt) {
			return (adjoinEmptyCnt - s.adjoinEmptyCnt) * -1;
		}
		// 2-2 (3)
		if (x != s.x) {
			return x - s.x;
		}
		// 2-2 (4)
		return y - s.y;
	}
}

public class Main {
	static int students[];
	static int map[][];
	static HashMap<Integer, Set<Integer>> stdLikeMap;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, ans;

	public static void main(String[] args) throws IOException{
		// 1.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		students = new int[N*N];
		map = new int[N][N];
		stdLikeMap = new HashMap<>();
		
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			// 1-1
			int studentNum = Integer.parseInt(st.nextToken());
			students[i] = studentNum;
			stdLikeMap.put(studentNum, new HashSet<>());
			// 1-2
			for(int j=0; j<4; j++) {
				stdLikeMap.get(studentNum).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 2.
		selectSeats();
		
		// 3.
		getTotalSatisfaction();
		
		System.out.println(ans);
	}

	// 2.
	private static void selectSeats() {

		// 2-1
		for (int i = 0; i < N * N; i++) {
			int studentNum = students[i];
			Seat seat = setSeat(studentNum);
			map[seat.x][seat.y] = studentNum;
		}

	}

	private static Seat setSeat(int studentNum) {
		Seat seat = null;

		for (int cx = 0; cx < N; cx++) {
			for (int cy = 0; cy < N; cy++) {
				
				// 2-3
				if (map[cx][cy] != 0) {
					continue;
				}

				int likeStdCnt = 0;
				int adjoinEmptyCnt = 0;

				for (int d = 0; d < 4; d++) {
					int nx = cx + dirs[d][0];
					int ny = cy + dirs[d][1];

					// 2-4
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}
					
					// 2-5
					if (map[nx][ny] == 0) {
						adjoinEmptyCnt++;
					}
					
					// 2-6
					else {
						if (stdLikeMap.get(studentNum).contains(map[nx][ny])) {
							likeStdCnt++;
						}
					}

				}

				// 2-8 
				Seat cur = new Seat(cx, cy, likeStdCnt, adjoinEmptyCnt);

				if (seat == null) {
					seat = cur;
					continue;
				}

				if (seat.compareTo(cur) > 0) {
					seat = cur;
				}

			}
		}

		return seat;
	}

	// 3.
	private static void getTotalSatisfaction() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 3-1
				int likeStdCnt = getLikeStdCnt(i, j);
				// 3-2
				if (likeStdCnt > 0) {
					ans += Math.pow(10, likeStdCnt - 1);
				}

			}
		}
	}

	// 3-1
	private static int getLikeStdCnt(int cx, int cy) {
		int likeStdCnt = 0;

		int studentNum = map[cx][cy];
		
		for (int d = 0; d < 4; d++) {
			int nx = cx + dirs[d][0];
			int ny = cy + dirs[d][1];

			// 2-4
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) { 
				continue;
			}

			// 2-6 
			if (stdLikeMap.get(studentNum).contains(map[nx][ny])) {
				likeStdCnt++;
			}
		}

		return likeStdCnt;
	}
}