import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int step = length;
        int index = 0;
        
        for(int i=0;i<length;i++){
            answer+= Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i + 1;
            while(index<length && name.charAt(index) == 'A'){
                index++;
            }
            step = Math.min(step, Math.min(i*2+length-index, i+(length-index)*2));
        }
        
        answer += step;
        return answer;
    }
}
