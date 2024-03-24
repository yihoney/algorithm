import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times); // 오름차순으로 정렬
        long left = 0;
        long right = times[times.length-1] * (long)n;
        while(left<=right) {
            long mid = (left + right) / 2;
            long possible = 0;
            for(int i=0; i<times.length; i++) {
                possible += mid/times[i];
            }
            if(possible<n) {
                left = mid+1;
            } else {
                right = mid-1;
                answer = mid;
            }
        }
        
        return answer;
    }
}