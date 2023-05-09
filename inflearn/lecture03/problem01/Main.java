package inflearn.lecture03.problem01;

import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(n, arr1, m, arr2));
    }

    private static String solution(int n, int[] arr1, int m, int[] arr2) {
        StringBuilder ans = new StringBuilder();
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = start; j < m; j++) {
                if (arr1[i] < arr2[j]) {
                    ans.append(arr1[i] + " ");
                    break;
                } else {
                    ans.append(arr2[j] + " ");
                    start++;
                }
            }
        }
        if (start != arr2.length - 1) {
            for (int i = start; i < m; i++) {
                ans.append(arr2[i] + " ");
            }
        }

        return ans.toString();
    }
}
