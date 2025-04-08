import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * bfs로 각 노드를 탐색하여 인접 노드까지 전부 방문처리함
     * 한번 탐색이 완료되면 한 네트워크를 전부 방문한 것이므로 answer++
     * 
     * 시간 복잡도:
     * 노드 n개의 연결 n개를 확인하므로
     * O(n^2)
     */
  
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                queue.offer(i);
                visited[i] = true;
                
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    
                    for(int j = 0; j < n; j++){
                        if(computers[node][j] == 1 && !visited[j]){
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}
