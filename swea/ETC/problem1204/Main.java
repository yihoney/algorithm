package swea.problem1204;

import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[1000];
            int maxV = 0;
            int maxK = 0;
            for (int i = 0; i < 1000; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                int curV = map.get(arr[i]);
                if (curV > maxV) {
                    maxK = arr[i];
                    maxV = curV;
                } else if (curV == maxV) {
                    if (maxK < arr[i]) {
                        maxK = arr[i];
                    }

                }
            }
            System.out.println("#" + test_case + " " + maxK);
        }
    }
}