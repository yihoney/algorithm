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
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                ans.append(arr1[p1++] + " ");
            } else {
                ans.append(arr2[p2++] + " ");
            }
        }
        while (p1 < n) {
            ans.append(arr1[p1++] + " ");
        }
        while (p2 < m) {
            ans.append(arr2[p2++] + " ");
        }
        return ans.toString();
    }
}