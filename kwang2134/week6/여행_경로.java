package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행_경로 {
    /**
     * 풀이
     * 티켓을 정렬 출발지 알파벳순 + 도착지 알파벳순
     * 정렬된 티켓을 통해 dfs로 최적의 경로 탐색
     *
     * 시간 복잡도: O(n! x n)
     * 총 n!의 경로를 탐색하는데 경로마다 n번의 반복문 실행
     * 정렬의 시간 복잡도는 O(n log n) 이지만 경로 탐색에 비해 미비해 무시
     */

    private List<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        dfs(tickets, "ICN", new ArrayList<>(List.of("ICN")), new boolean[tickets.length]);

        return result.toArray(String[]::new);
    }

    private void dfs(String[][] tickets, String current, List<String> path, boolean[] isVisited) {
        if(!result.isEmpty()) return;

        if (path.size() == tickets.length + 1) {
            result = new ArrayList<>(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(isVisited[i]) continue;

            if (!tickets[i][0].equals(current)) continue;

            isVisited[i] = true;
            path.add(tickets[i][1]);
            dfs(tickets, tickets[i][1], path, isVisited);

            path.remove(path.size() - 1);
            isVisited[i] = false;
        }
    }
}
