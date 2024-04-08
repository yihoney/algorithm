class Solution {
    static int answer = 0;
    static boolean flags[];
    
    public int solution(String begin, String target, String[] words) {
        flags = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt) {
        // begin이 target으로 변환 완료 됐다면 종료
        if(begin.equals(target)) { 
            answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(flags[i]) {
                continue;
            }
            // 같은 알파벳이 몇 개인지 카운트
            int k=0;
            String cur = words[i];
            for(int j=0; j<cur.length(); j++) {
                if(cur.charAt(j)==begin.charAt(j)) {
                    k++;
                }
            }
            // 알파벳이 한 개만 다르다면
            if(k==cur.length()-1) {
                flags[i] = true;
                dfs(cur, target, words, cnt+1);
                flags[i]=false;
            }
        }
    }
}