package LimKangHyun.week11;

import java.util.*;

public class 폰켓몬 {
	/**
	 * 시간복잡도(Big-O) : O(N)
	 *
	 * 1. 주어진 배열을 순회하며 HashSet에 폰켓몬 종류를 저장 (중복 제거)
	 * 2. 선택할 수 있는 폰켓몬 수는 nums.length / 2
	 * 3. HashSet 크기(종류 개수)와 선택할 수 있는 수 중 작은 값을 반환
	 */
	public int solution(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int num : nums) set.add(num);
		return Math.min(set.size(), nums.length/2);
	}
}