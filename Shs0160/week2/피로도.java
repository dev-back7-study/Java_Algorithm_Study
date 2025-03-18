class Solution {
   
    //하나씩 타고 들어가서 확인 -> dfs
    //dfs니까 깊이를 확인할 변수 필요
    
    
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }
    
    int max = 0;
    
    public void dfs(int k, int[][] dungeons, int d){
        
        max = Math.max(max, d);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, d + 1);
                visited[i] = false;
            }
        }
    
    }
}
