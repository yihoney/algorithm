package inflearn.lecture07.problem06;

public class Main {
    static int n;
    static int[] check;

    public static void main(String[] args) {
        n = 3;
        check = new int[n + 1];
        DFS(1);
    }

    private static void DFS(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    sb.append(i + " ");
                }
            }
            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        } else {
            check[L] = 1;
            DFS(L + 1); // left
            check[L] = 0;
            DFS(L + 1); // right
        }
    }
}
