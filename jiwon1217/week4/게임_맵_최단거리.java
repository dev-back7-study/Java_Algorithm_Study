package jiwon1217.week4;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    /**
     * 문제 풀이
     * 1. maps를 BFS 탐색하며 최단거리 구하기
     * 시간 복잡도
     * n: 행, m: 열
     * O(n*m)
     */
    public int bfs(int[][] maps, int n, int m) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean[][] visit = new boolean[n][m];
        Queue<Integer> q = new LinkedList<>();

        visit[0][0] = true;
        q.add(0);
        q.add(0);
        q.add(1);

        while (!q.isEmpty()) {
            int cx = q.poll();
            int cy = q.poll();
            int cnt = q.poll();

            if (cx == n - 1 && cy == m - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) {
                    continue;
                }
                if (!visit[nx][ny] && maps[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    q.add(cnt + 1);
                }
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        return bfs(maps, n, m);
    }
}
