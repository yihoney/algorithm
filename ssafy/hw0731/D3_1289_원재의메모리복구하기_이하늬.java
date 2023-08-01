package ssafy.hw0731;

import java.io.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - SWEA 1289 원재의메모리복구하기
 *         아이디어
 *         - 모든 비트를 '0'으로 초기화
 *         - 재귀 호출로 이전 값과 현재 값을 비교하여 다른 경우 갯수를 세어주고, 이전 값을 현재 값으로 수정
 * 
 *         - 메모리: 18584KB, 시간: 110ms
 *         </pre>
 */

public class Solution {
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            ans = 0;
            String original = br.readLine();
            recursive(original, '0', 0);
            System.out.printf("#%d %d\n", i, ans);
        }
    }

    private static void recursive(String num, char tmp, int idx) {

        if (num.charAt(idx) != tmp) { // 이전 값과 다르면
            ans++; // 수정 횟수 ++
            tmp = num.charAt(idx); // 이전 값을 현재 값으로 수정
        }

        if (idx < num.length() - 1) {
            recursive(num, tmp, idx + 1);
        }
    }

}
