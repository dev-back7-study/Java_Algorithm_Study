import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * 주어진 정보로 그래프를 생성
     * 반복문을 이용해 엣지을 한번씩 제거
     * dfs를 통해 탐색해 이어진 노드가 몇개인지 찾음 
     * 전체 노드 수를 이용해 노드 수 차이를 계산
     * 모든 경우의 수를 탐색하면 answer에 최소 노드 수 차이가 저장됨
     *
     * 시간 복잡도:
     * DFS로 최대 n개의 노드 탐색
     * O(n^2)
     */
  
    public int solution(int n, int[][] wires) {
        int answer = n;

        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];

            graph.get(node1).remove(Integer.valueOf(node2));
            graph.get(node2).remove(Integer.valueOf(node1));

            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(graph, visited, node1);
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return answer;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int startNode) {
        visited[startNode] = true;
        int cnt = 1;

        for (int nextNode : graph.get(startNode)) {
            if (!visited[nextNode]) {
                cnt += dfs(graph, visited, nextNode);
            }
        }

        return cnt;
    }
}
