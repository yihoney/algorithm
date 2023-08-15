import java.io.*;
import java.util.*;

/**
 * 백준 1074 Z
 * 
 * 몇 번째로 방문하는지 찾아낼 (r,c)가 어떤 영역에 있는지가 중요
 * 
 * 그냥 size만을 기저조건으로 두고 재귀를 돌렸더니 시간초과가 나서
 * 찾으려는 위치가 속해있는 영역에 따라 넘겨주는 값을 재귀를 한 번 탈 때마다 갱신해줌
 * 
 * 숫자값은 영역에 따라 재귀 타기 전에 기존의 숫자값에 각 영역의 시작점을 더해줌
 * 
 * @author 이하늬
 * 
 */

public class Main {
    static int R, C, num;

    public static void main(String[] args) throws IOException {
        // long start = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 한 변의 사이즈는 2^N
        R = Integer.parseInt(st.nextToken()); // 찾으려는 행
        C = Integer.parseInt(st.nextToken()); // 찾으려는 열
        int size = (int) Math.pow(2, N);

        search(R, C, size);

        System.out.println(num);
        // long end = System.nanoTime();
        // System.out.println((end - start) / 1_000_000_000);
    }

    private static void search(int r, int c, int size) {

        if (size == 1) { // 기저 조건 -> 영역의 크기가 1이라면 종료
            return;
        }

        int half = size / 2;

        // 1 | 2
        // -----
        // 3 | 4
        // 로 영역을 나누었을 때

        if (r < half && c < half) { // 1
            // 시작점이 0이므로 아무 계산 안해줘도 됨
            search(r, c, half);
        }

        if (r < half && half <= c) { // 2
            num += half * half;
            search(r, c - half, half);

        }

        if (half <= r && c < half) { // 3
            num += (half * half) * 2;
            search(r - half, c, half);

        }

        if (half <= r && half <= c) { // 4
            num += (half * half) * 3;
            search(r - half, c - half, half);
        }
    }
}
