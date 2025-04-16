import java.util.*;

class Solution {
    
    /*
    DFS
    규칙 - 알파벳 하나만 다른 단어를 찾는다.
    찾으면 visited = true, cnt++
    DFS 재귀호출
    */
   
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        return dfs(visited, begin, target, words, 0);
    }
    
    
    public int dfs(boolean[] visited, String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            return cnt;
        }
        
        int min = words.length + 1;
        
        for(int i = 0; i<words.length; i++){
            if(!visited[i] && compare(begin, words[i])){
                visited[i] = true;
                int ans = dfs(visited, words[i], target, words, cnt + 1);
                if(ans != 0){ 
                    min = Math.min(min, ans);
                }
                visited[i] = false;
            }
        } 
        if(min == words.length + 1){
            return 0;
        }
        else{
            return min;
        }
        
    }
    
    public boolean compare(String begin, String word){
        int n = 0;
        for(int j = 0; j < begin.length(); j++){
            if(begin.charAt(j) != word.charAt(j)){
                n++;
            }
        }
        return n == 1;
    }
    
    
    
}
