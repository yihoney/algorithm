import java.io.*;
import java.util.*;

class Shark {
	int r, c, s, d, z;

	public Shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;// 속력
		this.d = d;// 이동 방향
		this.z = z;// 크기
	}
}

public class Main {
	static Shark board[][];
	static List<Shark> sharks;
	static int ans = 0, R, C, M;
	static int dirs[][] = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 위(1), 왼쪽(2), 아래쪽(3), 오른쪽(4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 격자판의 크기 R
		C = Integer.parseInt(st.nextToken()); // 격자판의 크기 C
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		sharks = new ArrayList<Shark>();
		board = new Shark[R + 2][C + 2];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 상어 위치 r
			int c = Integer.parseInt(st.nextToken()); // 상어 위치 c
			int s = Integer.parseInt(st.nextToken()); // 상어 속력 s
			int d = Integer.parseInt(st.nextToken()); // 상어 방향 d
			int z = Integer.parseInt(st.nextToken()); // 상어 크기 z

			d = (d == 1 ? 0 : d == 4 ? 1 : d); // 상(1)하(2)우(3)좌(4) -> 상(0)하(2)우(3)좌(1) 로 변경하기 위해 
			board[r][c] = new Shark(r, c, s, d, z);
			sharks.add(board[r][c]);
		}

		for (int kingC = 1; kingC <= C; kingC++) { // 1. 낚시왕 오른쪽으로 한 칸 이동, 가장 오른쪽 칸에 이동하면 이동 멈춤
			
			for (int r = 1; r <= R; r++) { // 2. 땅과 제일 가까운 상어를 잡음 -> 1행부터 시작
				if (board[r][kingC] == null) { // 상어가 없으면
					continue; // 아래의 내용 생략 및 다음 열 확인
				}

				Shark shark = board[r][kingC]; // 잡은 상어 !
				ans += shark.z; // 상어 크기만큼 더해주기
				board[r][kingC] = null; // 잡은 후에 현재 위치의 상어 사라지게 하기
				break;
			}
			// 상어 이동
			move();

		}
		System.out.println(ans);

	}

	public static void move() { // 모든 상어 이동 시키기

		Queue<Shark> queue = new LinkedList<>();

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				Shark shark = board[i][j];
				if (shark != null) { // 잡을 상어가 있다면
					queue.add(new Shark(i, j, shark.s, shark.d, shark.z)); // 현재 잡을 상어를 큐에 삽입
				}
			}
		}

		board = new Shark[R + 2][C + 2];

		while (!queue.isEmpty()) {
			Shark shark = queue.poll();
			int speed = shark.s;

			if (shark.d == 0 || shark.d == 2) { // 상/하 이면 속력은 (R-1)*2로 나눈 값
				speed %= (R - 1) * 2;
			}
			if (shark.d == 1 || shark.d == 3) { // 좌/우 이면 속력은 (C-1)*2로 나눈 값
				speed %= (C - 1) * 2;
			}
			// 우선 현재 위치로 초기화 후
			for (int s = 0; s < speed; s++) { // 속력만큼 이동해줌
				int nx = shark.r + dirs[shark.d][0];
				int ny = shark.c + dirs[shark.d][1];

				if (nx < 1 || R < nx || ny < 1 || C < ny) { // 범위를 벗어났을 경우 방향을 반대로 변경
					shark.r -= dirs[shark.d][0];
					shark.c -= dirs[shark.d][1];
					shark.d = (shark.d + 2) % 4; // 위일 경우 아래로, 아래일 경우 위로, 오른쪽일 경우 왼쪽으로, 왼쪽일 경우 오른쪽으로 변경
					continue;
				}

				// 상어 위치 이
				shark.r = nx;
				shark.c = ny;
			}

			if (board[shark.r][shark.c] == null) { // 이동할 위치에 상어가 없다면
				board[shark.r][shark.c] = shark; // 상어 이동시켜주기
			} else { // 이동할 위치에 상어가 있다면
				Shark sharkOgn = board[shark.r][shark.c];
				if (sharkOgn.z < shark.z) { // 기존에 있는 상어보다 현재 상어 크기가 더 크다면
					board[shark.r][shark.c] = shark;
				}

			}
		}	
	}
	
}