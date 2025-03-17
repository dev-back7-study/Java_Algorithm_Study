package week2;

public class 피로도 {
    /**
     * 풀이
     * dfs 를 사용해 유저가 방문할 수 있는 모든 던전 루트를 탐색해 최댓값을 찾음
     *
     * 시간 복잡도: O(n!)
     */
    private static int answer;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        boolean[] isVisited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, isVisited);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, int count, boolean[] isVisited) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];

            if (k < need || isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            dfs(k-use, dungeons, count + 1, isVisited);
            isVisited[i] = false;
        }
    }
}
