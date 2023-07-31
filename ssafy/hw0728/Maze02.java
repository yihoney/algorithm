package ssafy.hw0728;

import java.util.*;
import java.io.*;

class Location {
    int row;
    int col;

    public Location(String row, String col) {
        this.row = Integer.parseInt(row);
        this.col = Integer.parseInt(col);
    }
}

public class Maze02 {

    public static Point[] moveVal = new Point[] { new Point("-1", "0"), new Point("0", "1"),
            new Point("1", "0"), new Point("0", "-1") };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrN = Integer.parseInt(st.nextToken()); // 배열 크기
            Point start = new Point(st.nextToken(), st.nextToken()); // 출발점의 좌표

            int jumperN = Integer.parseInt(st.nextToken()); // 점퍼 갯수
            Point jprArr[] = new Point[jumperN]; // 점퍼 좌표가 담긴 배열
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < jumperN; j++) {
                jprArr[j] = new Point(st.nextToken(), st.nextToken());
            }

            int moveN = Integer.parseInt(br.readLine()); // 방향 지시의 갯수
            int moveArr[] = new int[moveN * 2]; // 방향 지시 배열
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < moveArr.length; j += 2) {
                moveArr[j] = Integer.parseInt(st.nextToken());
                moveArr[j + 1] = Integer.parseInt(st.nextToken());
            }

            System.out.printf("#%d %s\n", i, solution(arrN, start, jprArr, moveArr));
        }
    }

    private static String solution(int arrN, Point start, Point[] jprArr, int[] moveArr) {
        String str = null;

        for (int i = 0; i < moveArr.length; i += 2) {

            for (int j = 0; j < moveArr[i + 1]; j++) { // 이동 칸 수 만큼 반복
                start.row += moveVal[moveArr[i] - 1].row;
                start.col += moveVal[moveArr[i] - 1].col;

                // 이동한 좌표에 점퍼가 있을 경우 (0,0)
                for (Point l : jprArr) {
                    if (start.row == l.row && start.col == l.col) {
                        return "0 0";
                    }
                }

                // N*N 칸을 벗어났을 경우 (0,0)
                if (start.row < 0 || start.col < 0 || start.row > arrN || start.col > arrN) {
                    return "0 0";
                }
            }
        }

        str = start.row + " " + start.col;

        return str;
    }
}
