class Solution {
    
    int maxPlayedGames = 0;
    boolean visited[];
    
    public boolean canPlay(int k, int power) {
        if(k<power){
            return false;
        } else{
            return true;
        }
    }
    
    public void route(int[][] dungeons, int k, int n, int playedGame) {
        if(playedGame == dungeons.length){
            maxPlayedGames = Math.max(maxPlayedGames, playedGame);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!canPlay(k, dungeons[i][0])){
                maxPlayedGames = Math.max(maxPlayedGames, playedGame);
                continue;
            }
            
            if(!visited[i]){
                visited[i] = true;
                playedGame++;
                route(dungeons, k-dungeons[i][1], n, playedGame);
                visited[i] = false;
                playedGame--;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int playedGame = 0;
        
        visited = new boolean[dungeons.length];
        
        route(dungeons, k, dungeons.length, playedGame);
        
        answer = maxPlayedGames;
        
        return answer;
    }
}
