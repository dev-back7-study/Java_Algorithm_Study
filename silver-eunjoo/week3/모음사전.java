class Solution {
    
    int find = 0;
    int match = 0;
    
    public void dfs(String word, String[] alphabets, String dictionary){
        if(word.equals(dictionary)) {
            match = find;
            return;
        }
        
        if(dictionary.length() == 5){
            find++;
            return;
        }
        
        find++;
        
        for(int i=0;i<alphabets.length;i++){
            dfs(word, alphabets, dictionary+alphabets[i]);
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        String[] alphabets = {"A","E","I","O","U"};
        String dictionary = "";
        
        dfs(word, alphabets, dictionary);
        
        return match;
    }
}
