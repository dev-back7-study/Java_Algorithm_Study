class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int brownW = 0, brownH = 0; // brown 가로, 세로
        
        final int totalBlock = yellow + brown;
        
        for(int i = totalBlock; i>=1; i--){
            brownW=i;
            brownH=totalBlock/i;
            
            if(brownW<brownH){
                break;
            }
            if(totalBlock%i == 0){
                if((brownW+brownH) == ((brown/2) + 2)){
                    answer[0] = brownW;
                    answer[1] = brownH;
                }
            }
        }
        
        return answer;
    }
}
