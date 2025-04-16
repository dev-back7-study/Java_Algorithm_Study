package jiwon1217.week5;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {
    /**
     * 문제 풀이
     * 1. computers 연결 정보를 통해 그래프 구성
     * 2. DFS 수행하며 연결요소의 개수 세기
     * 시간 복잡도
     * n: 컴퓨터 개수
     * O(n^2)
     */
    private List<Integer>[] network;
    private boolean[] visit;

    public void dfs(int num) {
        visit[num] = true;

        for (int computer : network[num]) {
            if (!visit[computer]) {
                dfs(computer);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        network = new ArrayList[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    network[i].add(j);
                    network[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}
