package jiwon1217.week2;

public class 카펫 {
    /**
     * 문제 풀이
     * 1. yellow의 제곱근 만큼 반복문을 돌면서 yellow의 가로, 세로 값이 될 후보 값 찾기
     * 2. 1에서 구한 yellow를 기준으로 카펫을 구성했을 때 전체 카펫 수와 같은지 확인
     * 시간 복잡도 n: yellow의 크기
     * O(√n)
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 0, h = 0;

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                w = yellow / i;
                h = i;
            }
            if ((w + 2) * (h + 2) == (brown + yellow)) {
                answer[0] = w + 2;
                answer[1] = h + 2;
                break;
            }
        }
        return answer;
    }
}
