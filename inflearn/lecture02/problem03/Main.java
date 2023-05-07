package lecture02.problem03;

import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arrA = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(num, arrA, arrB));
    }

    private static String solution(int num, int[] arrA, int[] arrB) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (arrA[i] == arrB[i]) {
                ans.append("D" + "\n");
            } else if (arrA[i] == 2 && arrB[i] == 1) {
                ans.append("A" + "\n");
            } else if (arrA[i] == 3 && arrB[i] == 2) {
                ans.append("A" + "\n");
            } else if (arrA[i] == 1 && arrB[i] == 3) {
                ans.append("A" + "\n");
            } else {
                ans.append("B" + "\n");
            }
        }
        return ans.toString();
    }
}