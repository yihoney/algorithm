package lecture02.problem05;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));
    }

    private static int solution(int num) {
        int ans = 0;
        int[] arr = new int[num + 1];
        for (int i = 2; i < num; i++) {
            if (arr[i] == 0) {
                ans++;
                for (int j = i; j < num; j += i) {
                    arr[j] = 1;
                }
            }
        }
        return ans;
    }
}
