import java.util.*;

class Solution {
    String[] words = {"A", "E", "I", "O", "U"};
    int word_len = 5;
    
    public void dfs(List<String> list, String str){
        if(str.length() > word_len){
            return;
        }
        if(!list.contains(str)){
            list.add(str);
        }
        for(int i = 0; i<words.length; i++){
            dfs(list, str + words[i]);
        }
    }
    
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        int answer = 0;
        for(int i = 0; i<words.length; i++){
            dfs(list, words[i]);
        }
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i + 1;
                break;
            }
        }
        
        return answer;
           
    }
}
