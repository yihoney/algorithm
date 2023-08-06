package swea.ETC.problem1247;

import java.util.*;
import java.io.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - SWEA 1247 (최적 경로)
 *         첫째 줄: 고객의 수 N
 *         둘째 줄: 회사 좌표,집 좌표, N명의 고객의 좌표
 *         </pre>
 */

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= test_case; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<Point> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n + 2; i++) {
                arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            System.out.println("#" + tc + " " + solution(arr));
        }
    }

    private static int solution(List<Point> arr) {
        int ans = Integer.MAX_VALUE;

        return ans;
    }
}
