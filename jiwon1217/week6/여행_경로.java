package jiwon1217.week6;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 여행_경로 {
    /**
     * 문제 풀이
     * 1. 티켓 정보에 대한 맵 생성
     * 2. 알파벳 순서가 앞서는 경로를 선택하기 위해 우선순위 큐 사용
     * 3. DFS 수행하며 경로 탐색 후 결과 뒤집기
     * 시간 복잡도
     * E: 티켓의 수
     * O(E log E)
     */
    private final Map<String, PriorityQueue<String>> path = new HashMap<>();
    private final List<String> answer = new LinkedList<>();

    public void dfs(String airport) {
        PriorityQueue<String> pq = path.get(airport);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        answer.add(airport);
    }

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            path.putIfAbsent(ticket[0], new PriorityQueue<>());
            path.get(ticket[0]).add(ticket[1]);
        }
        dfs("ICN");
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }
}
