import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] result = {0, 0, 0};
        
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == num1[i%num1.length]){
                result[0]++;
            } 
            if(answers[i] == num2[i%num2.length]){
                result[1]++;
            }
            if(answers[i] == num3[i%num3.length]){
                result[2]++;
            }
        }
        
        int maxNum = Math.max(result[0], Math.max(result[1], result[2]));
        List<Integer> list = new ArrayList<>();
        
        
        if(maxNum == result[0]){
            list.add(1);
        }
        if(maxNum == result[1]){
            list.add(2);
        }
        if(maxNum == result[2]){
            list.add(3);
        }
        
        int[] ans = list.stream().mapToInt(i -> i).toArray();
        
        
        return ans;
    }
}
