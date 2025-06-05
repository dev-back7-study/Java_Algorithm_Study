package LimKangHyun.week9;

public class 큰_수_만들기 {
	/**
	 * 시간복잡도(BigO) : O(N)
	 *
	 * 앞자리부터 순차적으로 sb에 문자를 append하면서,
	 * - k가 0보다 크고
	 * - sb가 비어있지 않으며
	 * - 현재 들어온 문자가 sb의 마지막 문자보다 클 경우
	 *
	 * sb의 마지막 문자를 제거하고 k를 감소시킨다.
	 * sb.charAt(sb.length() - 1) < c 조건이 만족되지 않아서
	 * sb가 len을 초과한 길이일 수 있으므로, len만큼 문자를 선택해 반환
	 */
	public String solution(String number, int k) {
		int n = number.length();
		int len = n - k;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			char c = number.charAt(i);
			while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
				sb.deleteCharAt(sb.length() - 1);
				k--;
			}
			sb.append(c);
		}
		return sb.substring(0, len);
	}
}
