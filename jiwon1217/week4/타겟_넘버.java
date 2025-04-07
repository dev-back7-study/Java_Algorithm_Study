package jiwon1217.week4;

public class 타겟_넘버 {/**
    * 문제 풀이
    * 1. 주어진 numbers에 대해 더하기, 빼기 조합으로 만들 수 있는 모든 결과 계산
    * 2. target과 같은 결과의 개수 세기
    * 시간 복잡도
    * n: numbers의 길이
    * O(2^n)
    */
    private int answer;

    public void dfs(int[] numbers, int target, int sum, int idx) {
        if (numbers.length == idx) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, sum + numbers[idx], idx + 1);
        dfs(numbers, target, sum - numbers[idx], idx + 1);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}
