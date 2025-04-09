package LimKangHyun.week5;

public class 네트워크 {
    /**
     * dfs 시간복잡도(BigO) : O(N)
     * 전체코드 시간복잡도(BigO) : O(N^2)
     * 	모든 노드를 순회하면서 방문하지 않은 노드가 있으면 새 네트워크 시작 -> dfs 탐색 시작
     * 	노드에서 DFS를 통해 연결된 모든 컴퓨터를 방문 처리 → 하나의 네트워크로 취급
     * 	DFS가 끝날 때마다 네트워크 개수 (answer)를 증가시킴 -> answer++
     */
    private static boolean[] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                dfs(n, i, computers);
                answer++;
            }
        }
        return answer;
    }
    private static void dfs(int n, int node, int[][]computers) {
        visit[node] = true;
        for(int i = 0; i < n; i++) {
            if(!visit[i] && computers[node][i] == 1) {
                dfs(n, i, computers);
            }
        }
    }
}
