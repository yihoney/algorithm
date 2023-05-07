package lecture02.problem02;

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
        int ans = 1;
        int baseN = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > baseN) {
                baseN = arr[i];
                ans++;
            }
        }
        return ans;
    }
}