package programmers.hash;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (int n : map.values()) {
            answer *= n;
        }

        return answer - 1;
    }
}