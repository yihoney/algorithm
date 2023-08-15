import java.io.*;
import java.util.*;

/**
 * 백준 14225 부분수열의 합
 * 
 * 수열이 주어졌을 때, 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 문제
 * 
 * 플래그 배열을 만들어 구한 부분집합의 합에 해당하는 플래그를 true로 변경
 * 부분집합의 합을 다 구했다면, 가장 작은 자연수를 구해야하므로 인덱스 1부터 반복문을 돌며 플래그 배열에서 false인 값을 찾음
 * false는 부분집합의 합으로 나올 수 없는 수라는 의미이므로 해당 값을 출력!
 * 
 * 
 * @author 이하늬
 */

public class Main {

    static int N; // 수열 S의 크기
    static int[] arr; // 입력 받은 수열 저장할 배열
    static boolean[] flag; // 부분수열의 합으로 만들 수 있는 자연수를 체크하는 플래그 배열
    static boolean[] isSelected; // 요소가 선택 되었는지 체크할 플래그 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 부분집합 요소 갯수
        arr = new int[N]; // 부분집합의 요소들이 될 숫자들
        isSelected = new boolean[N]; // 해당 요소가 선택되었는지 체크할 배열
        flag = new boolean[100000 * 20 + 1]; // S(1<=S<=100000) * N(1<=N<=20) + 1

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        // 플래그 배열을 1부터(자연수이므로) 반복문으로 돌며 부분수열의 합으로 나오지 않은 수 찾기
        for (int num = 1; num < flag.length; num++) {
            if (!flag[num]) { // 부분 수열의 합으로 나오지 않은 수라면
                System.out.println(num); // 해당 수를 출력
                break; // 후 종료!
            }
        }

    }

    public static void solution(int cnt, int sum) {
        if (cnt == N) { // 모든 요소들을 다 고려해서 부분집합을 완성했다면
            flag[sum] = true; // 현재 부분집합의 합으로 나온 수의 플래그를 true로 변경
            return;
        }

        isSelected[cnt] = true; // cnt번째 요소 선택
        solution(cnt + 1, sum + arr[cnt]); // 선택했으므로 합에 해당 인덱스의 숫자를 더해 넘겨줌
        isSelected[cnt] = false; // cnt번째 요소 선택 하지 않음
        solution(cnt + 1, sum); // 선택하지 않았으므로 기존 sum값을 넘겨줌

    }
}
