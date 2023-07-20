package programmers.hash;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 프로그래머스 - 완주하지 못한 선수 (해시)
 *         아이디어
 *         - participant 배열에 있는 이름 중 completion 배열에 없는 사람을 찾음
 *         - participant 배열에 있는 사람들을 map에 넣은 후, completion 배열에 있는 사람들을 기존의 카운팅에서 1씩 빼줌 -> map에 남아있는 사람이 정답
 *         - 동명이인 주의
 *         </pre>
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) { // 참여자들을 한명씩 순회하며
            map.put(p, map.getOrDefault(p, 0) + 1); // key 값은 이름으로, value는 만약 map에 이미 존재하는 이름이라면 기존의 값에 +1을, 존재하지 않는
                                                    // 이름이라면 1을 저장
        }

        for (String c : completion) { // 완주자들을 한명씩 순회하며
            map.put(c, map.get(c) - 1); // map에서 이름에 해당하는 key 값에 대해 value를 1씩 마이너스 해줌
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) { // map 값 전체 출력
            if (e.getValue() != 0) { // value가 0이 아니라면
                answer = e.getKey(); // key 값(이름)을 answer에 저장
                break;
            }
        }

        return answer;
    }
}
