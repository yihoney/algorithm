package baekjoon.silver.s2_2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분집합의 합, 곱을 구해 해결
 * 
 * @author 이하늬
 * 
 */

public class Main2 {
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

        if (cnt == N) { // 부분집합을 완성했다면
            if (!isNotAllSelected()) { // 부분집합 요소들이 모두 X일 경우 (한번도 방문을 안했을 경우)
                MIN = Math.min(MIN, Math.abs(sum - mul)); // 기존 값이랑 현재 sum이랑 mul의 차이를 비교해 더 작을 값을 저장
            }
            return;
        }

        isSelected[cnt] = true; // 선택 플래그를 O로 변경
        recursive(cnt + 1, sum + ingredients[cnt][1], mul * ingredients[cnt][0]); // 이전 값에 더하고, 곱해서 재호출
        isSelected[cnt] = false; // 선택 플래그를 X로 변경
        recursive(cnt + 1, sum, mul); // 선택하지 않았으므로 이전 값 그대로 넘겨 재호출
    }

    private static boolean isNotAllSelected() { // 모든 요소가 다 X인지 판별하는 함수
        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i] == true) { // 하나라도 방문했다면
                return false; // false 반환
            }
        }
        return true;
    }
}