package week5;

public class 네트워크 {
    /**
     * 풀이
     * dfs 를 통해 각 노드에서 연결을 검사해 네트워크 확인
     *
     * 시간 복잡도: O(n^2)
     * O(n)의 시간 복잡도를 가진 dfs 를 루프에서 n 번 호출
     */
    private void dfs(int computer, int[][] computers, boolean[] isVisited){
        if(isVisited[computer]) return;
        isVisited[computer] = true;

        for (int i = 0; i < computers.length; i++) {
            if(computers[computer][i] == 0) continue;
            dfs(i, computers, isVisited);
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(isVisited[i]) continue;
            dfs(i, computers, isVisited);
            answer++;
        }
        return answer;
    }
}
