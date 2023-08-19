import java.io.*;
import java.util.*;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static char map[][];
	static int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
	static char direct[] = new char[] { '^', 'v', '<', '>' };
	static char move[] = new char[] { 'U', 'D', 'L', 'R' };
	static StringBuilder sb = new StringBuilder();
	static int H, W, dir, N;
	static char moveArr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 맵의 높이
			W = Integer.parseInt(st.nextToken()); // 맵의 너비

			map = new char[H + 2][W + 2];
			Point start = null;
			for (int i = 1; i <= H; i++) {
				String str = br.readLine();
				for (int j = 1; j <= W; j++) {
					char ch = str.charAt(j - 1);
					map[i][j] = ch;
					for (int c = 0; c < direct.length; c++) {
						if (ch == direct[c]) {
							dir = c;
							map[i][j] = '.';
							start = new Point(i, j);
						}
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			moveArr = br.readLine().toCharArray();

			sb.append("#").append(tc).append(" ");
			start(start);
		}
		System.out.println(sb);
	}

	private static void start(Point start) {
		int nx = start.x;
		int ny = start.y;

		for (int i = 0; i < N; i++) {
			char current = moveArr[i];
			int cx = nx;
			int cy = ny;
			if (current == 'U' || current == 'D' || current == 'L' || current == 'R') {
				for (int c = 0; c < move.length; c++) {
					if (current == move[c]) {
						dir = c;
						break;
					}
				}

				cx += dirs[dir][0];
				cy += dirs[dir][1];

				if (map[cx][cy] == '.') {
					nx = cx;
					ny = cy;
				}
			} else { // S일 때 포탄 쏘기
				while (true) {
					cx += dirs[dir][0];
					cy += dirs[dir][1];

					if (map[cx][cy] == 0 || map[cx][cy] == '#') {
						break;
					}

					if (map[cx][cy] == '*') {
						map[cx][cy] = '.';
                        break;
					}

				}
			}
		}

		map[nx][ny] = direct[dir];

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

	}
}
