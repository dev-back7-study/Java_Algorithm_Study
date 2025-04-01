package LimKangHyun.week4;

public class 타겟_넘버 {
    /**
     * dfs 시간복잡도(BigO) : O(2^N) -> +,- 분기가 생기므로 2의 N제곱
     * 전체코드 시간복잡도(BigO) : O(2^N)
     * calc = 0을 시작으로 numbers[] 원소들을 차례로 깊이 우선 탐색
     * numbers[]의 길이와 depth가 일치할 때, calc이 target과 일치하는지 확인
     * 같다면 answer++, dfs 종료 후, answer return
     */
    private static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    private static void dfs(int[] numbers, int depth, int target, int calc) {
        if (depth == numbers.length) {
            if(calc == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, depth+1, target, calc + numbers[depth]);
        dfs(numbers, depth+1, target, calc - numbers[depth]);
    }
}
