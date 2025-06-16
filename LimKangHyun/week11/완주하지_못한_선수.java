package LimKangHyun.week11;

import java.util.*;

public class 완주하지_못한_선수 {
	/**
	 * 시간복잡도(Big-O) : O(N)
	 *
	 * 1. 참가자 명단을 HashMap에 저장하면서 각 이름의 출현 횟수를 카운트
	 * 2. 완주자 명단을 순회하며 해당 이름의 출현 횟수를 1씩 감소
	 * 3. HashMap을 순회하여 값이 0보다 큰 이름(완주하지 못한 사람)을 반환
	 */
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();

		for(String i : participant) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for(String i : completion) {
			map.put(i, map.get(i) - 1);
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 0) {
				return entry.getKey();
			}
		}
		return "";
	}
}
