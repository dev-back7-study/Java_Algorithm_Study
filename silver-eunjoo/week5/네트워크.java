class Solution {
    
    boolean[] visited;
    
    public int dfs(int[][] computers, int index) {
        if(!visited[index]){
            visited[index] = true;
        }
            
        for(int i=0;i<computers.length;i++){
            if(index==i) {
                continue;
            }
            if(!visited[i] && (computers[index][i])==1) {
                dfs(computers, i);
            }
        }
        
        return 1;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n+1];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer += dfs(computers, i);
            }
        }
        
        return answer;
    }
}
