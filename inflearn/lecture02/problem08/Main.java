package lecture02.problem08;

import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(num, arr));
    }

    private static String solution(int num, int[] arr) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int cnt = 1;
            for (int j = 0; j < num; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            ans.append(cnt + " ");
        }
        return ans.toString();
    }
}
