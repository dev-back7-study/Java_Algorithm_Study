package week6;

import java.util.ArrayList;
import java.util.List;

public class 퍼즐_조각_채우기 {
    /**
     * 풀이
     * 퍼즐 조각을 좌표로 관리
     * (0, 0) 을 기준으로 퍼즐 조각의 위치를 정규화
     * 퍼즐 조각과 빈 공간을 dfs 를 통해 좌표를 중첩 리스트에 보관
     * 조각 좌표와 빈 공간 좌표를 매칭 시켜 모두 일치하면 조각이 끼워지는 것으로 판단
     * 퍼즐 조각 좌표를 회전하여 회전한 조각이 빈 공간에 끼워지는 지 확인
     *
     * 시간 복잡도: O(n^4) ?
     * 4중 중첩문이 사용되는 것 같습니다..
     */


    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        List<List<Node>> emptySpaces = findSpaces(game_board, 0);

        List<List<Node>> puzzlePieces = findSpaces(table, 1);

        boolean[] used = new boolean[puzzlePieces.size()];
        int answer = 0;

        for (List<Node> emptySpace : emptySpaces) {
            for (int i = 0; i < puzzlePieces.size(); i++) {
                if (used[i]) continue;

                List<Node> piece = puzzlePieces.get(i);
                boolean matched = false;

                for (int r = 0; r < 4; r++) {
                    if (isSameShape(emptySpace, piece)) {
                        used[i] = true;
                        answer += piece.size();
                        matched = true;
                        break;
                    }
                    piece = rotate(piece);
                }

                if (matched) break;
            }
        }

        return answer;
    }

    private List<List<Node>> findSpaces(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<Node>> spaces = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    List<Node> space = new ArrayList<>();
                    dfs(board, i, j, visited, space, target);

                    normalize(space);
                    spaces.add(space);
                }
            }
        }

        return spaces;
    }

    private void dfs(int[][] board, int x, int y, boolean[][] visited, List<Node> space, int target) {
        int n = board.length;

        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || board[x][y] != target) {
            return;
        }

        visited[x][y] = true;
        space.add(new Node(x, y));

        for (int i = 0; i < 4; i++) {
            dfs(board, x + dx[i], y + dy[i], visited, space, target);
        }
    }

    private void normalize(List<Node> coords) {
        if (coords.isEmpty()) return;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Node node : coords) {
            minX = Math.min(minX, node.x);
            minY = Math.min(minY, node.y);
        }

        for (Node node : coords) {
            node.x -= minX;
            node.y -= minY;
        }

        coords.sort((a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });
    }

    private List<Node> rotate(List<Node> piece) {
        List<Node> rotated = new ArrayList<>();

        for (Node node : piece) {
            rotated.add(new Node(-node.y, node.x));
        }

        normalize(rotated);
        return rotated;
    }

    private boolean isSameShape(List<Node> shape1, List<Node> shape2) {
        if (shape1.size() != shape2.size()) return false;

        for (int i = 0; i < shape1.size(); i++) {
            Node p1 = shape1.get(i);
            Node p2 = shape2.get(i);

            if (!p1.equals(p2)) {
                return false;
            }
        }

        return true;
    }
}
