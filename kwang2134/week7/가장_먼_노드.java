package week7;

import java.util.*;

public class 가장_먼_노드 {
    /**
     * 풀이
     * 그래프 생성 후 bfs 를 통한 최단거리 탐색
     *
     * 시간 복잡도: O(n + m)
     * n: 정점 개수
     * m: 간선 개수
     */
    private static class State {
        public final int node;
        public final int step;

        public State(int node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public int solution(int n, int[][] edges) {
        Map<Integer, List<Integer>> Nodes = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            Nodes.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            Nodes.get(edge[0]).add(edge[1]);
            Nodes.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(1, 0));
        dist[1] = 0;

        int maxStep = 0;

        while (!queue.isEmpty()) {
            State state = queue.poll();
            int currentNode = state.node;
            int currentStep = state.step;

            for (int nextNode : Nodes.get(currentNode)) {
                if (dist[nextNode] == -1) {
                    dist[nextNode] = currentStep + 1;
                    queue.offer(new State(nextNode, currentStep + 1));
                    if (dist[nextNode] > maxStep) {
                        maxStep = dist[nextNode];
                    }
                }
            }
        }

        int count = 0;
        for (int d : dist) {
            if (d == maxStep) {
                count++;
            }
        }

        return count;
    }
}
