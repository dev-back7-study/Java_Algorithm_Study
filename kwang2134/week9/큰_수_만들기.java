package week9;

import java.util.ArrayDeque;
import java.util.Deque;

public class 큰_수_만들기 {
    /** 풀이
     * 스택을 사용해 큰 수가 밑으로 가게 쌓은 뒤 k개를 제거한 후 남는 길이 만큼 반환
     * 큰 수가 밑으로 가게 쌓은 스택은 꺼낼 때 반대로 꺼내지게 되므로 reverse() 처리
     *
     * 시간 복잡도: O(n)
     *
     */

    public String solution(String number, int k) {
        int targetLen = number.length() - k;
        Deque<Character> stk = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        char[] numArr = number.toCharArray();


        for(int i = 0; i < numArr.length; i++){
            if(stk.isEmpty()){
                stk.push(numArr[i]);
                continue;
            }


            while(!stk.isEmpty() && k > 0){

                if(stk.peek() < numArr[i]){
                    stk.pop();
                    k--;
                }
                else{
                    break;
                }
            }

            stk.push(numArr[i]);

        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        String result = sb.reverse().toString();

        result = result.substring(0, targetLen);

        return result;
    }
}
