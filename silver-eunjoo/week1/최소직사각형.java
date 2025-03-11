class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // sizes[]를 정렬한다. 내림차순
        // sizes[]의 최댓값 * sizes[][]의 최댓값이 답
        
        for(int i=0;i<sizes.length;i++){
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int firstMax = 0;
        int secondMax = 0;
        
        for(int i=0;i<sizes.length;i++){
            if(firstMax<sizes[i][0]){
                firstMax = sizes[i][0];
            }   
            if (secondMax<sizes[i][1]) {
                secondMax = sizes[i][1];
            }
        }
        
        answer = firstMax * secondMax;
        
        return answer;
    }
}
