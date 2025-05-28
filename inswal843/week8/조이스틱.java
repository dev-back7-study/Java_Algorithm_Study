class Solution {
    /**
     * 풀이
     * 
     * 각 문자를 A에서 목표 문자로 변경하는 최소 조작 횟수 계산 (상하 이동)
     * 커서를 이동하는 최소 횟수 계산 (좌우 이동)
     * 연속된 A 를 고려해 최단의 이동 경로 선택
     * 
     * 시간 복잡도:
     * 문자열 길이 n에 대해 계산
     * O(n)
     */
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        for (int i = 0; i < len; i++) {
            char target = name.charAt(i);
            int up = target - 'A';
            int down = 'Z' - target + 1;
            answer += Math.min(up, down);
        }
        
        int minMove = len - 1;
        
        for (int i = 0; i < len; i++) {
            int nextIdx = i + 1;
            while (nextIdx < len && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }
            
            int moveRight = 2 * i + len - nextIdx;
            int moveLeft = i + 2 * (len - nextIdx);
            
            minMove = Math.min(minMove, Math.min(moveRight, moveLeft));
        }
        
        answer += minMove;
        return answer;
    }
}
