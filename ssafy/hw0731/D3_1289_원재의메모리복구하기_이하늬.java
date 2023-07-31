package ssafy.hw0731;

import java.io.*;

public class Main {
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
