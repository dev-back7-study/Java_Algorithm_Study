package jiwon1217.week10;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {

    public int solution(int n, int[][] costs) {
        /**
         * 문제 풀이
         * 1. 비용 순으로 간선 정렬
         * 2. 간선 탐색하며 최소신장트리 생성
         * 시간 복잡도
         * M: 간선의 개수
         * O(M log M)
         */
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        int totalCost = 0;
        int edgeCount = 0;

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int bridgeCost = cost[2];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                totalCost += bridgeCost;
                edgeCount++;

                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        return totalCost;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
