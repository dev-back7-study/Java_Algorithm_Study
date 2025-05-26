package jiwon1217.week8;

public class 체육복 {
    /**
     * 문제 풀이
     * 1. 도난, 여분 체육복 정보를 담은 배열 생성
     * 2. 배열 탐색하며 채육복 분배
     * 시간 복잡도
     * N: 학생의 수
     * O(N)
     */
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i : lost) {
            arr[i]--;
        }

        for (int i : reserve) {
            arr[i]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == -1) {
                if (i != 1 && arr[i - 1] == 1) {
                    arr[i - 1]--;
                    arr[i]++;
                } else if (i != n && arr[i + 1] == 1) {
                    arr[i + 1]--;
                    arr[i]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 0) {
                answer++;
            }
        }
        return answer;
    }
}
