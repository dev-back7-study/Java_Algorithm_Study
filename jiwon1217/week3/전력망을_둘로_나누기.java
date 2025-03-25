package jiwon1217.week3;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {
    /**
     * 문제 풀이
     * 1. 주어진 간선 정보로 양방향 그래프 생성
     * 2. 간선을 하나씩 제거
     * 3. dfs를 수행하면서 연결 요소에 포함된 정점의 개수 세기
     * 4. 두 연결 요소의 정점의 개수 차이 구하기
     * 5. 차이가 최소가 될 때의 값 구하기
     * 시간 복잡도
     * n: 송전탑의 개수
     * O(n^2)
     */
    private List<Integer>[] g;

    public int dfs(int cur, boolean[] visit) {
        visit[cur] = true;
        int cnt = 1;
        for (int next : g[cur]) {
            if (!visit[next]) {
                cnt += dfs(next, visit);
            }
        }
        return cnt;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            g[from].add(to);
            g[to].add(from);
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            g[from].remove(Integer.valueOf(to));
            g[to].remove(Integer.valueOf(from));

            boolean[] visit = new boolean[n + 1];

            int cnt = dfs(1, visit);
            int temp = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, temp);

            g[from].add(to);
            g[to].add(from);
        }
        return answer;
    }
}
