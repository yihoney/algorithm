import java.io.*;
import java.util.*;

/**
 * 
 * 백준 15686 치킨배달
 * 
 * <문제 요약>
 * - 집과 치킨집 사이의 치킨거리: |r1-r2| + |c1-c2| / 도시의 치킨거리 : 모든 집의 치킨거리의 합
 * - 폐업시키지 않을 치킨집을 최대 M개 고름 -> 치킨집 중 M개의 치킨집을 뽑는 조합 생성
 * 
 * <아이디어>
 * 1. 입력 시 치킨집과 집을 분류해 각 배열에 저장
 * 2. 최대 M개의 치킨집을 고를 때 도시치킨거리의 최솟값을 골라야하므로 M개의 치킨집을 뽑는 조합 메서드 생성해 호출
 * 3. 조합 생성이 완료될 때마다 해당 치킨집들과 기존의 집들을 가지고 도시치킨거리를 구함
 * 4. 3번 수행 시 기존의 도시치킨거리보다 현재 구한 도시치킨거리가 더 작다면 정답값 갱신
 * 
 */

class Point { // 위치를 쉽게 저장하기 위한 클래스
    int r; // 행
    int c; // 열

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static Point[] chickenArr; // 치킨집들의 위치를 저장할 배열
    static Point[] homeArr; // 집들의 위치를 저장할 배열
    static Point[] curChickenArr; // 조합 시 뽑은 치킨집을 저장할 배열
    static int cityChickenDist = Integer.MAX_VALUE; // 가장 작은 도시의 치킨 거리 (최종 정답값 저장해둘 변수)

    public static void main(String[] args) throws IOException {
        // long start = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 정보는 N*N 주어짐
        int M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집의 최대 갯수

        chickenArr = new Point[13]; // 치킨집의 개수는 최대 13이라고 주어짐
        homeArr = new Point[2 * N]; // 집의 개수는 2N개를 넘지 않는다고 주어짐

        int idxChicken = 0; // 치킨집 배열 인덱스 초깃값 (실제 데이터 갯수를 파악하기 위함)
        int idxHome = 0; // 집 배열 인덱스 초깃값 (실제 데이터 갯수를 파악하기 위함)

        for (int i = 0; i < N; i++) { // 입력값을 집과 치킨집으로 분류해 각 배열에 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken()); // 입력받은 값이
                if (num == 1) { // 집이라면 homeArr에 저장
                    homeArr[idxHome++] = new Point(i, j);
                } else if (num == 2) { // 치킨집이라면 chickenArr에 저장
                    chickenArr[idxChicken++] = new Point(i, j);
                }
            }
        }

        // 기존 배열에 실제 값을 가지는 데이터들만 갖고있도록 배열 복사하여 저장
        homeArr = Arrays.copyOf(homeArr, idxHome);
        chickenArr = Arrays.copyOf(chickenArr, idxChicken);

        // chickenArr에 저장되어 있는 치킨집 중 M개를 뽑는 메서드 호출
        curChickenArr = new Point[M]; // M개의 치킨집을 가지므로 크기가 M인 배열 선언
        getCombiChickenArr(0, 0, M); // 조합 생성 메서드 호출

        System.out.println(cityChickenDist); // 최소 도시치킨거리 출력
        // long end = System.nanoTime();

        // System.out.println("수행시간: " + (end - start) / 1_000_000_000.0);
    }

    /**
     * 
     * 입력받은 치킨집들 중 r개의 치킨집을 뽑는 메서드 (조합 수행)
     * 
     * @param cnt      // 현재까지 뽑은 치킨집 갯수
     * @param startIdx // 조합 시도를 할 때 시작할 인덱스 (중복 허용하지 않기 위해 시작 인덱스 기억 목적)
     * @param r        // 뽑을 치킨집 갯수
     */
    private static void getCombiChickenArr(int cnt, int startIdx, int r) {
        if (cnt == r) { // r개의 치킨집을 다 뽑았다면 (조합 생성 완료)
            int curChickenDist = getCityChickenDist(curChickenArr); // r개의 치킨집을 가지는 배열을 매개변수로 넘겨 해당 경우의 도시치킨거리 구함
            cityChickenDist = Math.min(cityChickenDist, curChickenDist); // 현재의 도시치킨거리와 기존의 도시치킨거리를 비교해 최소값 저장
            return;
        }

        for (int i = startIdx; i < chickenArr.length; i++) {
            curChickenArr[cnt] = chickenArr[i];
            getCombiChickenArr(cnt + 1, i + 1, r);
        }

    }

    /**
     * 치킨집 배열에 따른 도시치킨거리를 구하는 메서드
     * 
     * @param subChickenArr 조합 생성 메서드를 통해 생성한 치킨집 배열
     * @return 도시치킨거리
     */
    private static int getCityChickenDist(Point[] subChickenArr) {
        int dist; // 치킨거리
        int curCityChickenDist = 0; // 현재 도시치킨거리
        for (int h = 0; h < homeArr.length; h++) { // 모든 집의 치킨거리를 구하기 위한 반복문
            int minDist = Integer.MAX_VALUE; // 치킨거리는 집마다 바뀌므로 여기서 초기화! (최소 한 번은 바뀌어야 하므로 가장 큰 값을 초깃값으로 설정)

            for (int c = 0; c < subChickenArr.length; c++) { // 모든 치킨집과 현재 집의 거리를 구하기 위한 반복문
                // 집과 치킨집 사이의 치킨거리: |r1-r2| + |c1-c2|
                dist = Math.abs(homeArr[h].c - subChickenArr[c].c) + Math.abs(homeArr[h].r - subChickenArr[c].r);
                minDist = Math.min(minDist, dist); // 기존 치킨거리과 현재 구한 거리 중 더 작은 값이 현재 집의 치킨 거리
            }
            // 도시치킨거리: 모든 집의 치킨거리의 합
            curCityChickenDist += minDist;
        }
        return curCityChickenDist;
    }
}