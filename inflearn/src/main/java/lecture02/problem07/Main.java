package lecture02.problem07;

import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(num, arr));
    }

    private static int solution(int num, int[] arr) {
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            if (arr[i] == 1) {
                ++cnt;
                ans += cnt;
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
}
