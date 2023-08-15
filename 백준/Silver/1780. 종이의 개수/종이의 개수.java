import java.io.*;
import java.util.*;

/**
 * [백준 1780 종이의 개수]
 * 
 * -1, 0, 1 중 하나가 저장되어 있는 N*N 배열에
 * 1) 모두 같은 수로 되어있음 그대로 종이 사용
 * 2) 모두 같은 수로 되어있지 않다면 같은 크기의 종이 9개로 자른 후 다시 검사
 * 
 * -1, 0, 1로만 채워진 종이의 개수 구하기
 * 
 */

public class Main {
    static int arr[][];
    static int cntM1, cnt0, cntP1; // -1/0/1로 채워진 종이의 개수
    static boolean flag; // -1/0/1 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N);

        System.out.println(cntM1); // -1로만 채워진 종이의 개수
        System.out.println(cnt0); // 0로만 채워진 종이의 개수
        System.out.println(cntP1); // 1로만 채워진 종이의 개수
    }

    private static void solution(int r, int c, int size) {
        flag = true; // 플래그를 우선 true로 초기화

        // 반복문을 돌며 만약 해당 영역의 숫자가 처음 숫자랑 한개라도 다르다면 flag를 false로 변경
        int baseNum = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (baseNum != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) { // 영역의 모든 수가 같거나 영역의 size가 1이라면
            // 어차피 다 같거나 영역 크기가 1이라면 시작점의 숫자만 비교해도 됌
            if (arr[r][c] == -1) { // -1일 경우
                cntM1++;
            }
            if (arr[r][c] == 0) { // 0일 경우
                cnt0++;
            }
            if (arr[r][c] == 1) { // 1일 경우
                cntP1++;
            }
        } else { // 그렇지 않다면 색종이 9개로 나누기
            int newSize = size / 3; // 9(3*3) 이므로 영역의 새로운 size는 기존 size/3

            // 영역을 이렇게 나눈다면,
            // 1 | 2 | 3
            // ---------
            // 4 | 5 | 6
            // ---------
            // 7 | 8 | 9

            // 반복문을 돌며 1~9 영역을 다 검사하기 위해 재귀 호출
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solution(r + newSize * j, c + newSize * i, newSize);
                }
            }
        }

    }
}
