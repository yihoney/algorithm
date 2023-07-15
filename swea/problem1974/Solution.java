package swea.problem1974;

import java.util.*;
import java.io.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - SWEA 1974 (스도쿠검증)
 *         - 겹치는 숫자가 없을 경우 1, 그렇지 않을 경우 0 출력
 *         </pre>
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int[][] arr = new int[9][9];
        for (int tc = 1; tc <= test_case; tc++) {
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + solution(arr));
        }
    }

    private static int solution(int[][] arr) {
        int ans = 1;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!set1.add(arr[i][j]) || !set2.add(arr[j][i])) {
                    return 0;
                }
            }
            set1.clear();
            set2.clear();
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (!set1.add(arr[k + i][l + j])) {
                            return 0;
                        }
                    }
                }
                set1.clear();
            }
        }
        return ans;
    }
}
