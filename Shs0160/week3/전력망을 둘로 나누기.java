import java.util.*;

class Solution {
    
    /*
    연결 정보를 양방향으로 받음
    연결을 끊고 2개의 노드를 기준으로 DFS
    -> 하나의 연결을 끊으면 2개 노드를 기준으로 2개의 네트워크가 만들어지니까
    DFS로 끊어진 네트워크 노드 개수 count
    */
    ArrayList<Integer>[] graph;
    int min;
    
    public int dfs(int node, boolean[] visited){
        int count = 1;
        visited[node] = true;
        
        for(int i = 0; i<graph[node].size(); i++){
            int next = graph[node].get(i);
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }
        return count;
        
    }
    
    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList[n + 1];
        min = n;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        //양방향 연결 초기화
        for (int i = 0; i < wires.length; i++) {
            int n1 = wires[i][0];
            int n2 = wires[i][1];
            graph[n1].add(n2);
            graph[n2].add(n1);
            
        }
        
        //하나씩 끊어보고 다시 연결
        for (int i = 0; i < wires.length; i++){
            int n1 = wires[i][0];
            int n2 = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];
            
            //Integer.valueOf 안해주면 IndexOutOfBoundsException 에러뜸
            graph[n1].remove(Integer.valueOf(n2));
            graph[n2].remove(Integer.valueOf(n1));
            
            int count = dfs(1, visited);
            
            int sub = Math.abs(count - (n - count));
            
            min = Math.min(min, sub);
            
            graph[n1].add(n2);
            graph[n2].add(n1);
            
        }
        return min;
    }

}
