package LimKangHyun.week7;

import java.util.*;

public class 가장_먼_노드 {
	/**
	 * bfs 시간복잡도(BigO) : O(N + E) -> N은 노드, E는 간선 수
	 * 전체코드 시간복잡도(BigO) : O(N + E)
	 *
	 * list에 양방향으로 각 인접 노드를 저장
	 * 1번노드(거리 0)에서 bfs 진행
	 * 각 노드를 방문하면서 노드의 길이가 maxDist와 같다면 answer++
	 * maxDist가 갱신된다면 answer는 1로 초기화
	 * 탐색 종료 후, answer 반환
	 */
	private static List<List<Integer>> list = new ArrayList<>();
	private static boolean[] visit;
	public int solution(int n, int[][] edge) {
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		visit = new boolean[n + 1];
		for(int i = 0; i < edge.length; i++) {
			list.get(edge[i][0]).add(edge[i][1]);
			list.get(edge[i][1]).add(edge[i][0]);
		}
		return bfs();
	}
	private static int bfs() {
		int answer = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {1, 0});
		visit[1] = true;
		int maxDist = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int num = cur[0];
			int dist = cur[1];
			if (dist == maxDist) answer++;
			if (dist > maxDist) {
				maxDist = dist;
				answer = 1;
			}
			for (int neighbor : list.get(num)) {
				if (!visit[neighbor]) {
					queue.offer(new int[] {neighbor, dist + 1});
					visit[neighbor] = true;
				}
			}
		}
		return answer;
	}
}
