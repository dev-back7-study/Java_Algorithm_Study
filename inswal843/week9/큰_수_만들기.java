import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * 스택에 숫자를 하나씩 넣으면서 처리
     * k개를 모두 제거하지 못했다면 뒤에서부터 제거
     * 스택에 남은 숫자들이 최대값
     * 
     * 시간 복잡도:
     * 각 숫자는 최대 한 번 push되고 한 번 pop되므로
     * O(n)
     */
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int toRemove = k;
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            while (!stack.isEmpty() && toRemove > 0 && stack.peek() < current) {
                stack.pop();
                toRemove--;
            }
            
            stack.push(current);
        }
        
        while (toRemove > 0) {
            stack.pop();
            toRemove--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}
