import java.io.*;
import java.util.*;

/**
 * BJ 1759 암호만들기
 * 
 * 문제를 제대로 안읽어서 한 번 제출할 때마다 조건을 한 개씩 추가해줬다....
 * 빨리 풀으려는 조급한 마음보단 꼼꼼히 문제를 잘 읽는 것을 오늘부터 연습해야할 것 같다.
 * 
 * L개 중에 C를 뽑음!
 * 암호는 사전식으로 춮력해야 하므로 입력받은 암호 후보 문자들을 정렬한 후에 뽑아주면 된다.
 * 암호 완성 시 모음 1개 자음 2개를 포함하고 있는지 확인하는 메서드를 생성해 체크
 * 
 * @author 이하늬
 * 
 *         메모리 11640KB
 *         시간 84ms
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char arr[], ans[]; // 암호에 들어갈 알파벳 후보군, 완성된 암호
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 암호에 사용된 문자 종류
        arr = new char[C]; // 암호가 될 후보 문자들을 저장할 배열
        ans = new char[L]; // 조합으로 생성한 암호를 담을 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr); // 사전식으로 출력하기 위해 정렬

        solution(0, 0); // 조합 생성 메서드 호출

        System.out.println(sb);
    }

    /**
     * 조합으로 암호를 생성하는 메서드
     * 
     * @param start 선택을 시작할 인덱스
     * @param cnt   고려한 요소 갯수
     */
    private static void solution(int start, int cnt) {

        if (cnt == L) { // 암호 완성
            StringBuilder str = new StringBuilder();
            for (char c : ans) {
                str.append(c); // 배열에 담아놓은 암호를 문자열화
            }

            // 모음이 최소 1개, 자음이 최소 2개 포함되어 있는지 확인
            if (isContainedVowel(str.toString()) && isContainedConsonant(str.toString())) {
                sb.append(str).append("\n"); // 조건을 만족하면 StringBuilder에 추가
            }

            return;
        }

        // 중복 선택되지 않게 하기 위해서 인덱스를 start부터 시작
        for (int i = start; i < C; i++) {
            ans[cnt] = arr[i]; // cnt번째 인덱스에 i번째 문자 저장
            solution(i + 1, cnt + 1); // 그 다음 문자 고르기
        }
    }

    /**
     * 모음을 최소 1개라도 포함하는지 확인하는 메서드
     * 
     * @param str 확인할 문자열
     * @return 최소 1개라도 포함한다면 true/ 아니면 false
     */

    private static boolean isContainedVowel(String str) {
        char vowel[] = new char[] { 'a', 'e', 'i', 'o', 'u' }; // 모음들
        for (char v : vowel) {
            // 만약 암호에 모음이 포함되어 있다면 (1개라도)
            if (str.contains(String.valueOf(v))) {
                return true; // 바로 true 반환
            }
        }
        // 여기까지 왔다면 모음을 포함하지 않는 것이기 때문에 false 반환
        return false;
    }

    /**
     * 자음을 최소 2개 포함하는지 확인하는 메서드
     * 
     * @param str 확인할 문자열
     * @return 최소 2개라도 포함한다면 true/ 아니면 false
     */
    private static boolean isContainedConsonant(String str) {
        char vowel[] = new char[] { 'a', 'e', 'i', 'o', 'u' };
        int cnt = 0; // 자음 몇 개 들어있는지 카운트할 변수

        for (char c : str.toCharArray()) { // 넘겨받은 문자열을 한글자씩 체크해보기
            boolean flag = true; // 모음이라면 플래그를 false로 변경해주기 위해 초깃값 true로 설정

            for (char v : vowel) { // 모음 한글자씩 확인
                if (c == v) { // 암호 중 현재 살펴보고 있는 한 글자가 만약 모음이라면
                    flag = false; // 플래그를 false로 변경
                    break; // 반복문 탈출 -> 한개라도 모음이 나오면 자음이 아니라는 소리니깐
                }
            }

            if (flag) { // 만약 자음을 포함한다면
                cnt++; // 자음 포함 카운트 갯수 늘려주기
            }

            if (cnt == 2) { // 자음이 두 개 이상이면
                return true; // 바로 true 반환
            }
        }

        // 여기까지 왔다면 자음을 2개 이상 포함하지 않는 것이므로 false 반환
        return false;
    }
}