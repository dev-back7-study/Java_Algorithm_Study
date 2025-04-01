import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * bfs를 이용하여 시작지점부터 도착지점까지의 최단경로를 탐색
     * 큐에는 x 좌표, y 좌표, cnt(거리)를 저장
     * bfs이므로 처음 도착지점에 도달했을 때의 cnt가 최단거리임이 보장됨
     * 도착지에 도달하지 못하고 탐색이 끝난 경우 -1 반환
     * 
     * 시간 복잡도:
     * 최악의 경우 모든 칸을 다 방문하므로
     * O(n * m)
     */
  
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1}); // x, y, cnt
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (x == n - 1 && y == m - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }
}
