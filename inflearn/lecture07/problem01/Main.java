package inflearn.lecture07.problem01;

public class Main {
    public static void main(String[] args) {
        recursive(3);
    }

    private static void recursive(int n) {
        if (n == 0) {
            return;
        } else {
            recursive(n - 1);
            System.out.println(n + " ");
        }
    }
}
