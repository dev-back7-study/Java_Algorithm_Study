package jiwon1217.week2;


public class 피로도 {
    /**
     * 문제 풀이
     * 1. 현재 피로도를 갱신하면서 최소 피로도를 만족하는 던전을 탐색
     * 2. 방문한 던전의 개수 갱신
     * 시간 복잡도
     * n: dungeons의 길이
     * O(n!)
     */
    private static boolean[] visit = new boolean[5001];
    private static int answer;

    public void backtracking(int cur, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int spend = dungeons[i][1];

            if (!visit[i] && cur >= need) {
                visit[i] = true;
                backtracking(cur - spend, dungeons, cnt + 1);
                visit[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        backtracking(k, dungeons, 0);
        return answer;
    }
}
