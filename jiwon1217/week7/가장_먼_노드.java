package jiwon1217.week7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드 {
    /**
     * 문제 풀이
     * 1. 주어진 정보로 그래프 구성
     * 2. BFS를 수행하며 레벨별 탐색
     * 3. 가장 높은 레벨의 노드의 개수 세기
     * 시간 복잡도
     * V: 정점의 수
     * E: 간선의 수
     * O(V + E)
     */
    private List<Integer>[] g;
    private boolean[] visit = new boolean[20001];
    private int answer = 0;

    public int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        q.add(0);
        visit[num] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int cur_level = q.poll();

            if (level == cur_level) {
                answer++;
            } else if (cur_level > level) {
                level = cur_level;
                answer = 1;
            }

            for (int i = 0; i < g[cur].size(); i++) {
                int next = g[cur].get(i);
                if (!visit[next]) {
                    q.add(next);
                    q.add(level + 1);
                    visit[next] = true;
                }
            }
        }
        return answer;
    }

    public int solution(int n, int[][] edge) {
        g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];

            g[from].add(to);
            g[to].add(from);
        }
        return bfs(1);
    }

}
