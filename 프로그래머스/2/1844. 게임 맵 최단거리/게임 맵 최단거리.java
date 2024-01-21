import java.util.*;

class Solution {
    static int n, m;
    public int solution(int[][] maps) {
        int answer = 0;
        
        n=maps.length;
        m=maps[0].length;
        
        
        int dirs[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        
        visited[0][0]=1;
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int cx = cur[0];
            int cy = cur[1];
            
            for(int d=0; d<4; d++) {
                int nx = cx+dirs[d][0];
                int ny = cy+dirs[d][1];
                
                if(!inRange(nx, ny)) {
                    continue;
                }
                
                if(visited[nx][ny]==0 && maps[nx][ny]==1) {
                    visited[nx][ny]=visited[cx][cy]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        answer = visited[n-1][m-1]==0?-1:visited[n-1][m-1];
        
        return answer;
    }
    
    public boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}