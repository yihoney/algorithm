import java.util.*;

class Solution {
    public int solution(int[] nums) {
    int size = nums.length / 2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
        map.put(n, map.getOrDefault(n, 0) + 1);
    }
    return map.size() >= size ? size : map.size();
    }
}