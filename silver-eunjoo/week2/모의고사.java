import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] scores = {0,0,0};
        
        for(int i=0;i<answers.length;i++){
            if(answers[i] == p1[i%5]){
                scores[0]++;
            }
            if(answers[i] == p2[i%8]) {
                scores[1]++;
            }
            if(answers[i] == p3[i%10]) {
                scores[2]++;
            }
        }
        
        int maxNum = Math.max(scores[0], Math.max(scores[1],scores[2]));
        
        List<Integer> maxNums = new ArrayList<>();
        
        for(int i=0;i<3;i++){
            if(maxNum == scores[i]){
                maxNums.add(i+1);
            }
        }
        
        answer = new int[maxNums.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = maxNums.get(i);
        }
        
//         answer = maxNums.stream()
// 	        .mapToInt(Integer::intValue)
//     	    .toArray();
        
        
        return answer;
    }
}
