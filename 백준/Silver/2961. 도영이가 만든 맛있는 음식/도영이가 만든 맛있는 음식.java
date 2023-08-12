import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] ingredients;
    static boolean[] isSelected;
    static int N, MIN;
    static int SUM, MUL = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2]; // col 0: 신맛, col 1: 쓴맛
        isSelected = new boolean[N]; // col 0: 신맛, col 1: 쓴맛
        MIN = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }
        recursive(0, SUM, MUL);
        System.out.println(MIN);
    }

    private static void recursive(int cnt, int sum, int mul) {

        if (cnt == N) {
            if (!isNotAllSelected()) {
                MIN = Math.min(MIN, Math.abs(sum - mul));
            }
            return;
        }

        isSelected[cnt] = true;
        recursive(cnt + 1, sum + ingredients[cnt][1], mul * ingredients[cnt][0]);
        isSelected[cnt] = false;
        recursive(cnt + 1, sum, mul);
    }

    private static boolean isNotAllSelected() {
        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i] == true) { // 하나라도 방문했다면
                return false;
            }
        }
        return true;
    }
}