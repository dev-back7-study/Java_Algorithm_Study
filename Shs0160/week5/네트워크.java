class Solution {
    
    /*
    DFS
    */
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited, computers);
                answer++;   
            }    
        }
       
        return answer;
    }
    public void dfs(int index, boolean[] visited, int[][] computers){
        visited[index] = true;
        int cnt = 0;
        for(int i = 0; i < computers.length; i++){
            if(index != i && !visited[i] && computers[index][i] == 1){
                dfs(i, visited, computers);
            }          
        }
    }
}
