package inflearn.lecture07.problem02;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }

    private static void solution(int n) {
        if (n == 0) {
            return;
        } else {
            solution(n / 2);
            System.out.print(n % 2);
        }
    }

}