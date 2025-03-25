import java.util.*;

class Solution {
    
    int count = 0;
    
    public void dfs(List<Integer>[] graph, int startNode, boolean[] visited) {
        
        if(visited[startNode]) {
            return;
        }
        
        count++;
        visited[startNode] = true;
        
        for(Integer i : graph[startNode]) {
            if(!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        boolean[] visited = new boolean[n+1];
        
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        int min = 101;
        
        for(int i=0;i<wires.length;i++){
            count = 0;
            for(int j=0;j<wires.length;j++){
                if(i==j){
                    continue;
                }
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            dfs(graph, 1, visited);
            min = Math.min((int)Math.abs((n-count)-count), min);
            visited = new boolean[n+1];
            for(int k=1;k<=n;k++) {
                graph[k].clear();
            }
        }
        
        answer = min;
        
        return answer;
    }
}
