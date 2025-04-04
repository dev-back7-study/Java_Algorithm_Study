import java.util.*;
class Solution {
    
    public int bfs(int[][] maps) {
    
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        Queue<int[]> character = new LinkedList<>();
        int[] start = {1,1};
        character.offer(start);
        
        while(!character.isEmpty()) {
            int[] location = character.poll();
            int x = location[0];
            int y = location[1];
            // System.out.println("x = " + x + ", y = " + y);
            
            for(int i=0;i<4;i++){
                int tx = x + dx[i];
                int ty = y + dy[i];
                    
                if(tx < 1 || ty < 1 || tx > n || ty > m) {
                    continue;
                } // 범위를 벗어나는 경우 
                if(maps[tx-1][ty-1] == 0){
                    continue;
                } // 지도에서 벽이 있는 경우
                if(maps[tx-1][ty-1] == 1) {
                    // System.out.println(tx + " " + ty);
                    maps[tx-1][ty-1] = maps[x-1][y-1] + 1;
                    int[] next = {tx,ty};
                    character.offer(next);    
                }
            }
        }
        return maps[n-1][m-1];
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(maps);
        if(answer == 1) {
            return -1;
        }
        
        return answer;
    }
}
