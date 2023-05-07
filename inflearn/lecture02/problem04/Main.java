package lecture02.problem04;

import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));
    }

    private static String solution(int num) {
        StringBuilder ans = new StringBuilder();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            if (i == 0 || i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
            ans.append(arr[i] + " ");
        }
        return ans.toString();
    }
}
