package jiwon1217.week6;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기 {
    /**
     * 문제 풀이
     * 1. 사각형 내부와 외부를 구분할 수 있도록 그래프 생성
     * 2. 경계를 구분할 수 있도록 좌표 * 2
     * 3. BFS 수행하며 최단거리 탐색
     * 시간 복잡도
     * n: 가로, m: 세로
     * O(n*m)
     */
    private final int SIZE = 101;
    public int[] dx = {0, 0, -1, 1};
    public int[] dy = {-1, 1, 0, 0};

    public boolean[][] visit = new boolean[SIZE][SIZE];
    public int[][] map = new int[SIZE][SIZE];

    int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Integer> q = new LinkedList<>();
        visit[characterX][characterY] = true;
        q.add(characterX);
        q.add(characterY);
        q.add(0);

        while (!q.isEmpty()) {
            int cx = q.poll();
            int cy = q.poll();
            int cnt = q.poll();

            if (cx == itemX && cy == itemY) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int n_cnt = cnt + 1;

                if (nx < 1 || ny < 1 || nx >= SIZE || ny >= SIZE) {
                    continue;
                }
                if (visit[nx][ny] || map[nx][ny] != 2) {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
                q.add(n_cnt);
            }
        }
        return 0;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for (int[] point : rectangle) {
            int x1 = point[0] * 2;
            int x2 = point[2] * 2;
            int y1 = point[1] * 2;
            int y2 = point[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] != 1) {
                            map[i][j] = 2;
                        }
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
        }
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
}
