package week4;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    /**
     * 풀이
     * 최단거리 -> bfs
     * bfs 는 레벨별 순차 탐색을 수행해 처음 만나게 되는 순간이 항상 최단거리
     *
     * 시간 복잡도: O(n * m)
     * 모든 노드를 한 번씩 방문
     */

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    private static class Location{
        public final int x;
        public final int y;
        public final int step;

        private Location(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<Location> que = new LinkedList<>();
        int targetX = maps[0].length-1;
        int targetY = maps.length-1;

        que.add(new Location(0,0,1));
        isVisited[0][0] = true;

        while(!que.isEmpty()){
            Location location = que.poll();

            if(location.y == targetY && location.x == targetX)
                return location.step;

            for(int i = 0; i < 4; i++){
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];

                if(ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length){
                    continue;
                }

                if(maps[ny][nx] != 1)
                    continue;

                if(isVisited[ny][nx]){
                    continue;
                }

                isVisited[ny][nx] = true;
                que.add(new Location(nx, ny, location.step+1));
            }
        }

        return -1;
    }
}
