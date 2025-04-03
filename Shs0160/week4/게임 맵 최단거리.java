import java.util.*;

class Solution {
    /*
    좌표를 두고 동서남북을 탐방
    BFS -> 큐에 현재 x,y 좌표와 거리 저장
    visited로 방문 여부 관리
    목적지에 도착했을 때 현재까지의 거리 return
    */
    
    public int solution(int[][] maps) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
              
        int n = maps.length;
        int m = maps[0].length;
              
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int[] ew = {0, 0, -1, 1};
        int[] ns = {-1, 1, 0, 0};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            
            if(x == n-1 && y == m - 1){
                return d;
            }
            
            for(int i = 0; i < 4; i++){
                int q_x = x + ew[i];
                int q_y = y + ns[i];
                
                //처음에 순서를 다르게 했더니 오류 발생 -> 왜지?
                if(q_x >= 0 && q_x < n && q_y >= 0 && q_x < n && q_y < m && maps[q_x][q_y] == 1 && !visited[q_x][q_y]){
                    visited[q_x][q_y] = true;
                    q.add(new int[]{q_x, q_y, d+1});
                }
                
            }
        }
        return -1;
    }
}

