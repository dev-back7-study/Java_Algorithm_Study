import java.util.*;
import java.util.stream.Collectors;

class Solution {
    boolean[] visited;
    List<String> routes = new ArrayList<>();
    int count = 0;
    
    public List<Integer> findDestination(String departure, String[][] tickets) {
        
        List<String[]> maps = new ArrayList<>();
        
        for(int i=0;i<tickets.length;i++){
            if(departure.equals(tickets[i][0]) && (!visited[i])){
                maps.add(new String[]{tickets[i][0],tickets[i][1], Integer.toString(i)});
            } 
        }
        
        Collections.sort(maps, (a, b) -> a[1].compareTo(b[1]));
        
        List<Integer> destinationIdx = maps.stream()
            .map(arr -> Integer.parseInt(arr[2]))
            .collect(Collectors.toList());
        
        return destinationIdx;
    }
    
    public int dfs(String[][] tickets, String departure, int count) {
        
        if(routes.size() == tickets.length+1) {
            return 1;
        }
        
        List<Integer> destinationIdx = findDestination(departure, tickets);
        
        if(destinationIdx.size() == 0){
            return -1;
        }
        
        for(Integer destination : destinationIdx) {
            visited[destination] = true;
            routes.add(tickets[destination][1]);
            int result = dfs(tickets, tickets[destination][1], count+1);
            if(result == -1) {
                routes.remove(count);
                visited[destination] = false;
            } else if (result == 1) {
                return 1;
            }
        }
        return -1;
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        routes.add("ICN");
        
        dfs(tickets, "ICN", count+1);
        
        answer = routes.stream().toArray(String[]::new);
        
        return answer;
    }
}
