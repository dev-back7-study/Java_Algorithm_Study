package week4;

public class 타겟_넘버 {
    /**
     * 풀이
     * 더하고 빼는 두 경우를 모두 고려하기 위해 각 단계에서 더하기 빼기 모두 수행
     * 모든 요소를 다 순회하고 나서 target 을 만들 수 있는 경우에 1을 반환
     *
     * 시간 복잡도: O(2^n)
     * 더하기 빼기 2가지 선택을 수행하므로 2의 n 제곱
     */

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    public int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
