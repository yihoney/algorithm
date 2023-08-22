import java.io.*;
import java.util.*;

/**
 * 
 * @author 이하늬
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char arr[], ans[];
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 암호에 사용된 문자 종류
        arr = new char[C];
        ans = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        solution(0, 0);

        System.out.println(sb);
    }

    private static void solution(int start, int cnt) {

        if (cnt == L) {
            StringBuilder str = new StringBuilder();
            for (char c : ans) {
                str.append(c);
            }

            if (isContainedVowel(str.toString()) && isContainedConsonant(str.toString())) {
                sb.append(str).append("\n");
            }

            return;
        }

        for (int i = start; i < C; i++) {
            ans[cnt] = arr[i];
            solution(i + 1, cnt + 1);
        }
    }

    private static boolean isContainedVowel(String str) {
        char vowel[] = new char[] { 'a', 'e', 'i', 'o', 'u' };
        for (char v : vowel) {
            if (str.contains(String.valueOf(v))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainedConsonant(String str) {
        char vowel[] = new char[] { 'a', 'e', 'i', 'o', 'u' };
        int cnt = 0;
        for (char c : str.toCharArray()) {
            boolean flag = false;

            for (char v : vowel) {
                if (c == v) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                cnt++;
            }

            if (cnt == 2) { // 자음이 두 개 이상이면
                return true;
            }
        }

        return false;
    }
}
