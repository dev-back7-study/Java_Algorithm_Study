package week7;

public class 순위 {
    /**
     * 풀이
     * 각 선수들의 승패를 그래프로 매핑
     * u가 이긴 모든 선수 탐색 -> 자기 자신 포함으로 -1
     * u에게 진 모든 선수 탐색 -> 자시 자신 포함으로 -1
     * 이긴 선수 + 진 선수 + 자신 == n 이라면 u의 순위를 확정할 수 있음
     * 즉 모든 선수와 경기를 치른 선수를 구하는 문제
     *
     * 시간 복잡도: O(n^3)
     * 각 노드마다 두 번 DFS 수행 -> 각 노드에 대해 최대 n번 호출이 가능하고 n개의 간선 검사 O(n^2)
     * 최악의 경우 n 번 반복으로 O(n^3)
     */

    private int countForward(int u, boolean[][] graph, boolean[] isVisited){
        int count = 1;

        for(int v = 0; v < graph[u].length; v++){
            if(!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }

        return count;
    }
    private int countBackward(int u, boolean[][] graph, boolean[] isVisited){
        int count = 1;
        for(int v = 0; v < graph.length; v++){
            if(!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }

        return count;
    }
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        for(int[] edge : results){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        int answer = 0;
        for(int u = 0; u < n; u++){
            int wins = countForward(u, graph, new boolean[n]) - 1;
            int loses = countBackward(u, graph, new boolean[n]) - 1;
            if(wins + loses + 1 == n){
                answer++;
            }
        }

        return answer;
    }
}
