import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> monster = new HashSet<>();
        
        for(Integer num : nums) {
            monster.add(num);
        }
        
        int size = nums.length/2;
        
        if(monster.size() <size) {
            answer = monster.size();
        } else {
            answer = size;
        }
        
        return answer;
    }
}
