class Solution {
    /**
     * 풀이
     *
     * bfs로 numbers 배열을 순회하며 각 원소에 -. + 하는 모든 경우의 수를 탐색
     * 배열의 끝까지 탐색한 경우 target값과 같은지 확인해 cnt 값을 증가
     *
     * 시간복잡도: 
     * -, + 로 2가지 분기가 있으므로 배열의 길이가 n 인 경우
     * O(2^n)
     */
  
    private int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
    
    private void dfs(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }

        dfs(numbers, target, sum + numbers[idx], idx + 1);
        dfs(numbers, target, sum - numbers[idx], idx + 1);
    }
}
