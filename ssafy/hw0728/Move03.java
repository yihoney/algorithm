package ssafy.hw0728;

import java.io.*;
import java.util.*;

class Score {
    int dir; // 방향
    int num; // 횟수

    public Score(char dir, char num) {
        this.dir = Character.getNumericValue(dir);
        this.num = Character.getNumericValue(num);
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Player {
    Point point;
    int num; // 횟수

    public Player(String row, String col, String num) {
        this.point = new Point(Integer.parseInt(row), Integer.parseInt(col));
        this.num = Integer.parseInt(num);
    }
}

public class Move03 {
    public static Point[] moveVal = new Point[] { new Point(-1, 0), new Point(-1, 1), new Point(0, 1),
            new Point(1, 1), new Point(1, 0), new Point(1, -1), new Point(0, -1), new Point(-1, -1) };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowN = Integer.parseInt(st.nextToken()); // 배열 크기
            int colN = Integer.parseInt(st.nextToken()); // 배열 크기
            int n = Integer.parseInt(st.nextToken()); // 참가자 수

            Score arr[][] = new Score[rowN][colN]; // 숫자판 정보
            for (int row = 0; row < rowN; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < colN; col++) {
                    String str = st.nextToken();
                    arr[row][col] = new Score(str.charAt(0), str.charAt(1));
                }
            }

            Player players[] = new Player[n]; // 숫자판 정보
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                players[j] = new Player(st.nextToken(), st.nextToken(), st.nextToken());
            }

            System.out.printf("#%d %s\n", i, solution(arr, players));
        }
    }

    private static int solution(Score[][] arr, Player[] players) {
        int ans = 0;
        for (Player player : players) {
            for (int i = 0; i < player.num; i++) { // 사용자의 횟수만큼 반복
                Score score = arr[player.point.row - 1][player.point.col - 1]; // 사용자의 위치 기반으로 점수판 정보 가져오기
                player.point.row += moveVal[score.dir - 1].row * score.num; // 점수판 정보를 따라 사용자 위치 변경
                player.point.col += moveVal[score.dir - 1].col * score.num; // 점수판 정보를 따라 사용자 위치 변경
                if (player.point.row <= 0 || player.point.col <= 0
                        || player.point.row > arr.length || player.point.col > arr[0].length) { // 경계를 벗어났다면 반복문 탈출
                    break;
                }
            }
            if (player.point.row <= 0 || player.point.col <= 0
                    || player.point.row > arr.length || player.point.col > arr[0].length) { // 경계를 벗어난 경우
                ans += -1000;
            } else { // 정상
                Score score = arr[player.point.row - 1][player.point.col - 1];
                ans += (score.dir * 10 + score.num) * 100;
                ans += -1000; // 참가비
            }
        }
        return ans;
    }
}
