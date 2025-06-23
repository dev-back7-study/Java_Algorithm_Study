package LimKangHyun.week12;

import java.util.*;

public class 전화번호_목록 {
	/**
	 * 시간복잡도(Big-O) : O(N log N)
	 *
	 * 1. 전화번호 배열 사전순 정렬 (작은 숫자부터 정렬)
	 * 2. 정렬된 phone_book에서 인접한 두 번호를 비교
	 * 3. startsWith이 true면 값은 false, startsWith이 false면 값은 true
	 */
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}
		return true;
	}
}