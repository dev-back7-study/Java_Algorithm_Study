import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * 참가자 이름을 HashMap에 저장하며 동명이인 카운트
     * 완주자 이름을 확인하며 HashMap에서 카운트 감소
     * 카운트가 0이 아닌 이름이 완주하지 못한 선수
     * 
     * 시간 복잡도:
     * O(n)
     */
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}
