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
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            check[L] = 1;
            DFS(L + 1); // left
            check[L] = 0;
            DFS(L + 1); // right
        }
    }
}
