package week6;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기 {

    /**
     * 풀이
     * 좌표를 정확하게 체크하기 위해 2배로 확장
     * 2차원 배열에 사각형 테두리를 모두 매핑하고 겹치는 내부를 제거해 외부 테두리만 남김
     * bfs를 통해 최단 경로 찾기
     *
     * 시간 복잡도 :O(R) R은 사각형 개수
     * 사각형을 매핑하거나 bfs를 수행하는 범위가 상수로 고정되어 있기 때문에 (102 x 102) 상수 시간으로 처리
     */

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static class Location {
        public final int x;
        public final int y;
        public final int step;

        public Location(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] matrix = new int[102][102];

        for (int[] rect : rectangle) {
            int leftX = rect[0] * 2;
            int leftY = rect[1] * 2;
            int rightX = rect[2] * 2;
            int rightY = rect[3] * 2;

            for (int x = leftX; x <= rightX; x++) {
                matrix[x][leftY] = 1;
                matrix[x][rightY] = 1;
            }

            for (int y = leftY; y <= rightY; y++) {
                matrix[leftX][y] = 1;
                matrix[rightX][y] = 1;
            }
        }

        for (int[] rect : rectangle) {
            int leftX = rect[0] * 2;
            int leftY = rect[1] * 2;
            int rightX = rect[2] * 2;
            int rightY = rect[3] * 2;

            for (int i = leftX + 1; i < rightX; i++) {
                for (int j = leftY + 1; j < rightY; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        Queue<Location> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[102][102];
        que.offer(new Location(characterX * 2, characterY * 2, 0));
        isVisited[characterX * 2][characterY * 2] = true;

        while(!que.isEmpty()) {
            Location location = que.poll();

            if(location.x == (itemX * 2) && location.y == (itemY * 2)) {
                return location.step / 2;
            }

            for(int d = 0; d < 4; d++) {
                int nx = location.x + dx[d];
                int ny = location.y + dy[d];

                if(nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[nx].length)
                    continue;

                if(matrix[nx][ny] == 0 || isVisited[nx][ny])
                    continue;

                que.offer(new Location(nx, ny, location.step + 1));
                isVisited[nx][ny] = true;
            }
        }

        return 0;
    }
}
