class Solution {
    /**
     * 방문 여부와 남은 피로도를 보고 탐험이 가능한지 판단
     * 탐험이 가능하면 방문처리 후 횟수를 증가시키고 다음 던전으로 이동
     * 
     * 모든 경우의 수를 보고 난 후 answer에는 최대 방문가능 횟수가 저장됨
     */
    
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        goDungeon(k, dungeons, visited, 0);
        return answer;
    }

    public void goDungeon(int k, int[][] dungeons, boolean[] visited, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                goDungeon(k - dungeons[i][1], dungeons, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
