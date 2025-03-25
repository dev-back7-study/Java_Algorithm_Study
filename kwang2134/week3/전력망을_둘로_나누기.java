package week3;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {
    /**
     * 풀이
     * 전력망의 연결을 만들고 실제(물리적)로 연결을 해제한 후 차를 구하는 방법
     * 연결 해제가 가능한 모든 케이스를 수행하고 가장 작은 값을 반환
     *
     * 시간 복잡도: O(n^2)
     * dfs: O(n)
     * dfs 를 solution 에서 n-1 번 수행 -> n^2 - n = n^2
     */
    private static class Node {
        List<Integer> connected;

        public Node() {
            this.connected = new ArrayList<>();
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = n;
        Node[] tree = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new Node();
        }

        for (int[] wire : wires) {
            tree[wire[0]].connected.add(wire[1]);
            tree[wire[1]].connected.add(wire[0]);
        }

        for(int[] wire : wires) {
            int w1 = wire[0];
            int w2 = wire[1];

            tree[w1].connected.remove(Integer.valueOf(w2));
            tree[w2].connected.remove(Integer.valueOf(w1));

            boolean[] isVisited = new boolean[n + 1];
            int count = dfs(tree, isVisited, 1);

            answer = Math.min(answer, Math.abs(count - (n - count)));

            tree[w1].connected.add(w2);
            tree[w2].connected.add(w1);
        }

        return answer;
    }

    private int dfs(Node[] tree, boolean[] isVisited, int current) {
        if (isVisited[current]) return 0;

        isVisited[current] = true;
        int count = 1;

        for(int next : tree[current].connected) {
            count += dfs(tree, isVisited, next);
        }

        return count;
    }
}
