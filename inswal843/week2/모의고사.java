import java.util.*;

class Solution {
    /**
     * 사람마다 찍는 패턴을 배열로 선언
     * 정답과 비교하며 맞추면 1씩 증가
     * 가장 큰 점수를 찾고 배열에 넣어 반환
     */
    public int[] solution(int[] answers) {
        int scoreFirst=0, scoreSecond=0, scoreThird=0;
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++){
            if(first[i%first.length] == answers[i]) scoreFirst++;
            if(second[i%second.length] == answers[i]) scoreSecond++;
            if(third[i%third.length] == answers[i]) scoreThird++;
            
        }
        
        int maxScore = Math.max(scoreFirst, Math.max(scoreSecond, scoreThird));
        
        List<Integer> answer = new ArrayList<>();
        
        if(scoreFirst==maxScore) answer.add(1);
        if(scoreSecond==maxScore) answer.add(2);
        if(scoreThird==maxScore) answer.add(3);
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
