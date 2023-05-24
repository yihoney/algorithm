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
        HashMap<Character, Integer> tmp = new HashMap<>();
        for (char c : str2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char c = str1.charAt(i);
            tmp.put(c, tmp.getOrDefault(c, 0) + 1);
        }
        int lt = 0;
        for (int rt = str2.length() - 1; rt < str1.length(); rt++) {
            tmp.put(str1.charAt(rt), tmp.getOrDefault(str1.charAt(rt), 0) + 1);
            if (map.equals(tmp)) {
                ans++;
            }
            tmp.put(str1.charAt(lt), tmp.get(str1.charAt(lt)) - 1);
            if (tmp.get(str1.charAt(lt)) == 0) {
                tmp.remove(str1.charAt(lt));
            }
            lt++;
        }

        return ans;
    }
}
