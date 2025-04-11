import java.util.*;
class Solution {
    
    public List<Integer> isConvertableIndex(String temp, String[] words) {
        
        List<Integer> idx = new ArrayList<>();
        int isDifferent = 0;
        
        char[] tempToChar = temp.toCharArray();
        char[] wordToChar;
        
        for(int i = 0;i<words.length;i++){
            wordToChar = words[i].toCharArray();
            isDifferent = 0;
            for(int j = 0;j< temp.length();j++){
                if(tempToChar[j] != wordToChar[j]){
                    isDifferent++;
                }
            }
            if(isDifferent == 1) {
                idx.add(i);
            }
        }
        
        return idx;
    }
    
    public int bfs(String begin, String target, String[] words) {
        
        int[] visited = new int[words.length];
        int count = 0;
        Queue<String> path = new LinkedList<>();
        List<Integer> idx = new ArrayList<>();
        
        path.offer(begin);
        path.offer("0");
        
        while(!path.isEmpty()) {
            String temp = path.poll();
            Integer stage = Integer.parseInt(path.poll());
            
            if(temp.equals(target)) {
                return stage;
            }
            
            idx = isConvertableIndex(temp, words);
            
            if(idx.size()==0){
                return count;
            }
            
            for(int i=0;i<idx.size();i++){
                
                if(visited[idx.get(i)] == 0){
                    visited[idx.get(i)] = stage + 1;
                    
                    path.offer(words[idx.get(i)]);
                    path.offer(Integer.toString(stage+1));
                }
                
            }
        }
        
        return count;
        
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        
        if(!wordList.contains(target)) {
            return answer;
        }
        
        answer = bfs(begin, target, words);
        
        
        return answer;
    }
}
