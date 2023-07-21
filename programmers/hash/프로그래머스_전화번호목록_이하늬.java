package programmers.hash;

import java.util.HashMap;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 프로그래머스 - 전화번호목록 (해시)
 *         아이디어
 *         - 입력 받은 phone_book 배열을 반복문을 돌려 한 개씩 HashMap에 넣어줌 (이 때 value는 상관이 없으므로 1 저장)
 *         - phone_book 배열에 있는 단어들을 반복문을 돌며 
 *           substring 메서드를 이용해 0번째 인덱스부터 단어의 길이-1 인덱스까지 1씩 증가시켜
 *           해당하는 범위의 문자열이 map에 저장되어 있는지 비교하여 저장되어 있다면 false 반환!
 *         </pre>
 */

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true; // answer을 true로 초기화

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : phone_book) { // 배열에 저장되어 있는 단어들을 map에 저장
            map.put(s, 1);
        }

        for (String s : phone_book) {
            for (int j = 2; j < s.length(); j++) { // substring(시작 인덱스, 종료인덱스) 메서드는 실제로는 시작인덱스-종료인덱스-1까지의 문자열을 반환하므로, 단어는 최소 1글자 이상이기 때문에 j의 초깃값은 2
                if (map.containsKey(s.substring(0, j))) { // map에 substring을 수행한 문자열이 포함되어 있다면
                    return false; // false 반환
                }
            }
        }

        return answer;
    }
}