package inflearn.lecture03.problem02;

import java.io.*;
import java.util.stream.*;
import java.util.*;

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
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                ans.append(arr1[p1++] + " ");
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return ans.toString();
    }
}
