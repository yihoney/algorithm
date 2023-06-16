package inflearn.lecture07.problem04;

public class Main {
    static int[] fibo;

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n + 1];
        solution(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i] + " ");
        }
    }

    private static int solution(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = solution(n - 2) + solution(n - 1);
        }
    }
}