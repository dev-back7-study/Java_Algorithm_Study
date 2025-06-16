import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> participants = new HashMap<>();
        
        for(String player : participant) {
            participants.put(player, participants.getOrDefault(player, 0) + 1);
        }
        
        for(String player : completion) {
            participants.put(player, participants.get(player) - 1);
        }
        
        for(String player : participants.keySet()) {
            if(participants.get(player)==1) {
                answer = player;
            }
        }
        
        return answer;
    }
}
