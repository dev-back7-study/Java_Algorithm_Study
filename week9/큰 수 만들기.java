import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> st = new Stack<>();
        int deleted = 0;
        
        for(char c : number.toCharArray()){
            while(!st.isEmpty() && deleted < k && c > st.peek()) {
                deleted++;
                st.pop();
            }    
            st.push(c);
        }
        
        while(deleted < k) {
            st.pop();
            deleted++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : st){
            sb.append(c);
        }
        
        return sb.toString();
    
    }
}
