import java.io.*;
import java.util.*;

/**
 * 백준 2630 색종이 만들기
 * 
 * 하얀색은 0, 파란색은 1 이므로 나눈 영역의 숫자들의 합이
 * 1) 영역 크기 * 영역 크기와 같다면 -> 그 영역은 모두 파란색
 * 2) 0이라면 -> 그 영역은 모두 하얀색
 * 이다. 만약 위의 두가지 경우를 다 만족하지 않는다면 다시 영역크기/2 * 영역크기/2로 영역을 나눠 위의 과정 반복
 *
 */

public class Main {
    static int arr[][];
    static int white, blue;

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

        System.out.println(white);
        System.out.println(blue);
    }

    private static void solution(int r, int c, int size) {

        if (size == 1) { // 기저 조건 -> 영역의 size가 1이 되면 더 이상 자를 수 없으므로
            if (arr[r][c] == 0) { // 단순 값 비교로 색깔에 따라 +1 처리
                white++;
            } else {
                blue++;
            }
            return; // 종료
        }

        int sum = 0; // 합을 저장해둘 변수

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == 0) { // 합이 0이라면
            white++; // 하얀색
        } else if (sum == (size * size)) { // 합이 영영크기*영역크기라면
            blue++; // 파란색
        } else { // 위의 경우 둘 다 아니라면 다른 색이 섞여있는 경우이므로
            int newSize = size / 2; // 새로 나눌 영역의 크기
            // 영역 나누기
            solution(r, c, newSize); // 1영역
            solution(r, c + newSize, newSize); // 2영역
            solution(r + newSize, c, newSize); // 3영역
            solution(r + newSize, c + newSize, newSize); // 4영역
        }

    }
}
