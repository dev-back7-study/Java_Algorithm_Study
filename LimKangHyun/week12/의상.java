package LimKangHyun.week12;

import java.util.*;

public class 의상 {
	/**
	 * 시간복잡도(Big-O) : O(N)
	 *
	 * 1. 입력된 옷 목록을 순회하며 종류별 옷 개수를 HashMap에 저장 (같은 종류 옷은 조합 불가하므로)
	 * 2. 각 종류별 옷 개수에 1을 더해(옷을 입지 않는 경우 포함) 곱함
	 * 3. 모든 경우의 수에서 아무것도 입지 않는 경우(1가지)를 빼서 최종 결과 반환 (시작값 1이므로)
	 */
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		for(String cloth[] : clothes) {
			String type = cloth[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
		int answer = 1;
		for(int i : map.values()) {
			answer *= (i + 1);
		}
		return answer - 1;
	}
}