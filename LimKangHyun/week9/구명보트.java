package LimKangHyun.week9;

import java.util.*;

public class 구명보트 {
	/**
	 * 시간복잡도(BigO) : O(N)
	 *
	 * 구명보트에 최대 2명을 태울 수 있으므로,
	 * 양 끝에서 가장 작은 사람과 큰 사람을 조합해 태우는 것이 제일 효율적
	 * i와 j의 합이 limit을 넘지않는다면, i와 j를 태우고
	 * i와 j의 합이 limit을 넘는다면, j만 태우기
	 * 태운만큼 answer++
	 */
	public int solution(int[] people, int limit) {
		int answer = 0;ㅋ
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;
		while (i <= j) {
			if (people[i] + people[j] <= limit) i++;
			j--;
			answer++;
		}
		return answer;
	}
}
