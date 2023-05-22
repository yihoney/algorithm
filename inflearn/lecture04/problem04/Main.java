package inflearn.lecture04.problem04;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str1, str2));
    }

    private static int solution(String str1, String str2) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.toCharArray()[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int lt = 0;
        int rt = 0;
        char[] arr = str1.toCharArray();
        while (rt < str1.length()) {
            char c = arr[lt++];
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
        }

        return ans;
    }
}
