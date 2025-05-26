package jiwon1217.week8;

public class 조이스틱 {
    /**
     * 문제 풀이
     * 1. 각 문자가 A와 가까운지 Z와 가까운지 확인해서 최소 변경 횟수 계산
     * 2. 커서 이동 횟수 계산
     *      - 오른쪽으로 가는 경우
     *      - 오른쪽으로 갔다가 왼쪽으로 돌아오는 경우
     *      - 왼쪽으로 갔다가 오른쪽으로 돌아오는 경우
     * 시간 복잡도
     * N: name의 길이
     * O(N)
     */
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int move = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + length - next);
            move = Math.min(move, (length - next) * 2 + i);
        }
        answer += move;
        return answer;
    }
}
