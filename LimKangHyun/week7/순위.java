package LimKangHyun.week7;

import java.util.*;

public class 순위 {
	/**
	 * 전체코드 시간복잡도(BigO) : O(N^3)
	 *
	 * graph[N+1][N+1] 배열에 각 선수를 기준으로 승(1), 패(-1) 기록
	 * 각 선수에 대해 i선수와 j선수에 대해 1승1패인 경우, i선수와 j선수의 승패도 결정가능
	 * 새롭게 결정된 승패를 graph에 기록
	 * 모든 선수에 대해 승패가 기록된 선수라면 등수를 정할 수 있으므로, answer++
	 */
	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] graph = new int[n+1][n+1];
		for(int[] result : results) {
			graph[result[0]][result[1]] = 1;
			graph[result[1]][result[0]] = -1;
		}
		for(int p = 1; p <= n; p++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if (graph[i][p] == 1 && graph[p][j] == 1) {
						graph[i][j] = 1;
					}
					if (graph[i][p] == -1 && graph[p][j] == -1) {
						graph[i][j] = -1;
					}
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			int fightCount = 0;
			for(int j = 1; j <= n; j++) {
				if(graph[i][j] != 0) fightCount++;
			}
			if(fightCount == n - 1) {
				answer++;
			}
		}
		return answer;
	}
}
