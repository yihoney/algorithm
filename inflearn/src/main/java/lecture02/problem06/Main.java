package lecture02.problem06;

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
            int reverse = 0;
            int tmp = arr[i];
            while (tmp > 0) {
                int n = tmp % 10;
                reverse = reverse * 10 + n;
                tmp /= 10;
            }
            if (isPrime(reverse)) {
                ans.append(reverse + " ");
            }
        }
        return ans.toString();
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
