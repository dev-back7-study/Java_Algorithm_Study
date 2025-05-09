package LimKangHyun.week6;

import java.util.*;

public class 여행경로 {
	/**
	 * dfs 시간복잡도(BigO) : O(N!)
	 * 전체코드 시간복잡도(BigO) : O(N!)
	 *
	 * 티켓 정렬: 알파벳 순 경로 우선순위 정렬
	 * DFS로 모든 가능한 경로 탐색 (백트래킹)
	 * 티켓 개수만큼 경로가 완성되면 answer 저장
	 * 무조건 ICN 출발이지만, 출발지가 ICN인 경우에 알파벳 빠른 순으로만 경로탐색을 고정하면 오답
	 * 따라서, 백트래킹을 위한 각 dfs 경우에 대한 visit배열 초기화 필수
	 */
	private static String[] answer;
	private static boolean[] visit;
	private static boolean isFinish;
	public String[] solution(String[][] tickets) {
		answer = new String[tickets.length + 1];
		visit = new boolean[tickets.length];
		//tickets 정렬(알파벳순으로 0번째, 1번째 순위로 정렬해도 ICN에 대한 알파벳 정렬은 정상적으로 이루어짐)
		Arrays.sort(tickets, (a, b) -> {
			if (a[0].equals(b[0])) {
				return a[1].compareTo(b[1]); // 둘다 아니면 2번째 원소로 비교
			}
			return a[0].compareTo(b[0]);
		});
		System.out.println(Arrays.deepToString(tickets));
		dfs("ICN", "ICN", tickets, 0);
		return answer;
	}
	private static void dfs(String departure, String path, String[][] tickets, int depth) {
		if (depth == tickets.length) {
			answer = path.split(",");
			isFinish = true;
			return;
		}
		for(int i = 0; i < tickets.length; i++) {
			if (!visit[i] && tickets[i][0].equals(departure)) {
				visit[i] = true;
				dfs(tickets[i][1], path + "," + tickets[i][1], tickets, depth+1);
				if (isFinish) break;
				visit[i] = false;
			}
		}
	}
}