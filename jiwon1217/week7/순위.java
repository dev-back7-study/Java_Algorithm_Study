package jiwon1217.week7;

public class 순위 {
    /**
     * 문제 풀이
     * 1. 주어진 정보로 그래프 구성
     * 2. 플로이드-워셜 알고리즘을 수행하며 승, 패 정보 갱신
     * 3. 확실하게 순위를 알 수 있느 선수의 수 세기
     * 시간 복잡도
     * N: 선수의 수
     * O(N^3)
     */
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
