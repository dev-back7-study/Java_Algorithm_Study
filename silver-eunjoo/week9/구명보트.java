import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int minIdx = 0;
        for(int i = people.length-1;i>=minIdx;i--){
            if(people[i] == limit) {
                answer++;
                continue;
            }
            if(people[i] + people[minIdx] <= limit) {
                answer++;
                minIdx++;
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}
