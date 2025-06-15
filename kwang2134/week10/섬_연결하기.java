package week10;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {
    /**
     * 풀이
     * 크루스칼 알고리즘 구현
     * 가장 비용이 적은 간선부터 선택해 사이클이 생기지 않도록 연결
     *
     * 시간 복잡도: O(E log E + E log n)
     * 정렬: O(E log E) E = 간선 개수
     * isConnected, merge 최악의 경우: O(log n)을 간선 개수만큼 수행 -> O(E log n)
     */
    private static class Node{
        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node node){
            return root() == node.root();
        }

        public void merge(Node node){
            if(isConnected(node)) return;

            Node root1 = root();
            Node root2 = node.root();

            if(root1.depth > root2.depth){
                root2.parent = root1;
            } else if(root1.depth < root2.depth){
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }
        private Node root(){
            if(parent == null) return this;
            return parent.root();
        }
    }

    private static class Edge{
        public final int u;
        public final int v;
        public final int cost;

        private Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {
        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2]))
                .sorted(Comparator.comparingInt(e -> e.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
        }

        int totalCost = 0;
        for(Edge e : edges){
            Node node1 = nodes[e.u];
            Node node2 = nodes[e.v];

            if(node1.isConnected(node2)) continue;
            node1.merge(node2);
            totalCost += e.cost;
        }

        return totalCost;
    }
}
