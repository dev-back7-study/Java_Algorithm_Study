package LimKangHyun.week8;

public class 조이스틱 {

	/**
	 * 전체코드 시간복잡도(BigO) : O(N)
	 *
	 * 각 칸에 대한 상하조작 먼저 계산 (upDownCnt)
	 * 0부터 n-1까지 이동하는 걸 baseMove로 설정하고,
	 * 'A'가 존재하는 경우,
	 * 해당 부분을 그대로 지나가는 이동과 오른쪽 이동 + 되돌아가기와 비교
	 * 왼쪽이동 + 되돌아가기와 비교
	 */
	public int solution(String name) {
		int updownCnt = 0;
		// 시작점부터 오른쪽으로 갈때, 이동 카운트
		int baseMove = name.length() - 1;
		int idx;
		for (int i = 0; i < name.length(); i++) {
			updownCnt += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));

			idx = i + 1;
			while(idx < name.length() && name.charAt(idx) == 'A') {
				idx++;
			}
			// 오른쪽으로 돌다가 되돌아갈경우
			baseMove = Math.min(baseMove, i * 2 + name.length() - idx);
			// 왼쪽으로 돌다가 되돌아갈경우
			baseMove = Math.min(baseMove, (name.length() - idx) * 2 + i);
		}
		return updownCnt + baseMove;
	}
}
