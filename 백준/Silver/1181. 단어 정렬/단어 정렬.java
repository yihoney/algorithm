import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = br.readLine();
        }
        System.out.println(solution(num, strArr));
    }

    private static String solution(int num, String[] strArr) {

        Arrays.sort(strArr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return s1.length() - s2.length();
            }
        });

        StringBuilder ans = new StringBuilder();

        ans.append(strArr[0]).append("\n");

        for (int i = 1; i < num; i++) {
            if (!strArr[i - 1].equals(strArr[i])) {
                ans.append(strArr[i]).append('\n');
            }
        }

        return ans.toString();
    }
}