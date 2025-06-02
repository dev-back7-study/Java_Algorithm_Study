package jiwon1217.week9;

import java.util.Stack;

public class 큰_수_만들기 {
    /**
     * 문제 풀이
     * 1. 숫자를 하나씩 스택의 TOP과 비교하며 큰 수 삽입
     * 2. K만큼 숫자 생성
     * 시간 복잡도
     * N: number의 길이
     * O(N)
     */
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();
        for (char num : number.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() < num) {
                st.pop();
                k--;
            }
            st.push(num);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder answer = new StringBuilder();
        for (char num : st) {
            answer.append(num);
        }
        return answer.toString();
    }
}
