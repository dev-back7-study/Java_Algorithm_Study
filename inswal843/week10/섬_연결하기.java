import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * 크루스칼 알고리즘(Kruskal's Algorithm) 사용
     * 모든 간선을 비용 기준으로 오름차순 정렬
     * Union-Find 자료구조를 사용하여 사이클 검사
     * 비용이 작은 간선부터 선택하며 사이클을 형성하지 않는 경우만 추가
     * n-1개의 간선을 선택하면 모든 섬이 연결됨
     * 
     * 시간 복잡도:
     * 정렬 O(E log E)
     * 
     */
    
    private int[] parent;
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) {
            return false;
        }
        
        parent[rootB] = rootA;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int edgeCount = 0;
        
        for (int[] edge : costs) {
            int island1 = edge[0];
            int island2 = edge[1];
            int cost = edge[2];
            
            if (union(island1, island2)) {
                totalCost += cost;
                edgeCount++;
                
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
}
