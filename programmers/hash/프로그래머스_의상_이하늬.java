package programmers.hash;

import java.util.HashMap;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 프로그래머스 - 의상 (해시)
 *         아이디어
 *         - key는 의상 종류이고 value는 의상 이름에 따라 카운트한 갯수를 갖는 해시를 생성
 *         - 모든 경우의 수를 구하기 위해 모든 value를 곱해준 뒤, 아무것도 입지 않은 경우를 포함하고 있기 때문에 -1을 해서 최종적으로 값을 리턴
 *         </pre>
 */

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; // 모든 경우의 수를 구하기 위해 초깃값을 1로 설정

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) { // clothes의 각 행은 [의상 이름, 의상 종류]로 이루어져 있음
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1); // key: 의상 종류, 기본 값을 안 입는 경우까지 포함하기 위해 1로 설정
        }

        for (int n : map.values()) {
            answer *= n; // map의 전체 value를 곱해줌
        }

        return answer - 1; // 모든 의상을 입지 않은 경우를 포함하므로 1을 빼줌
    }
}