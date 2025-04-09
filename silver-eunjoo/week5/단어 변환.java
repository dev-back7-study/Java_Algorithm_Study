import java.util.*;
class Solution {
    
    public List<Integer> compareString(String temp, String[] words) {
        
        List<Integer> idx = new ArrayList<>();
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        
        int n = temp.length();
        
        for(int i=0;i<words.length;i++){
            a.clear();
            b.clear();
            // 기준 문자열 
            for(String s : temp.split("")){
                a.add(s);
            }
            // 비교대상 문자열
            for(String s:words[i].split("")){
                b.add(s);
            }
            // 기준 문자열 - 비교대상 문자열
            for(String s: b){
                a.remove(s);
            }
            // 다른 게 한 개일 때
            if(a.size()==1) {
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
            
            // 문자 비교 -> 하나만 바꾸면 되는 걸로 (다른 게 하나인 걸로 큐에 넣는다.)
            // 다른 게 하나인 걸.... 어떻게 구현하면 좋을까..
            idx = compareString(temp, words);
            
            if(idx.size()==0){
                return count;
            }
            
            for(int i=0;i<idx.size();i++){
                if(visited[idx.get(i)] == 0){
                    System.out.println(words[idx.get(i)]);
                    visited[idx.get(i)] = stage + 1;
                    System.out.println(visited[idx.get(i)]);
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
