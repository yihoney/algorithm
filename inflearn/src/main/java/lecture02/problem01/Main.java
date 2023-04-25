package lecture02.problem01;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numArr = new int[num];
        for (int i = 0; i < num; i++) {
            numArr[i] = scanner.nextInt();
        }
        for (int n : solution(num, numArr)) {
            System.out.print(n + " ");
        }
    }

    private static List<Integer> solution(int num, int[] numArr) {
        List<Integer> ans = new ArrayList<>();
        ans.add(numArr[0]);

        for (int i = 1; i < num; i++) {
            if (numArr[i] > numArr[i - 1]) {
                ans.add(numArr[i]);
            }
        }
        return ans;
    }
}