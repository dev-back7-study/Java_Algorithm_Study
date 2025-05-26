package LimKangHyun.week8;

public class 체육복 {
	/**
	 * 전체코드 시간복잡도(BigO) : O(N)
	 *
	 * 학생 수만큼 배열을 입력하고, lost와 reserve를 배열에 표현
	 * stud 각 원소가 수업에 참여할 수 없는 경우, 양옆 여벌옷을 빌릴 수 있는지 확인
	 * 양옆에서 빌릴수 있다면 imp++
	 * 전체 학생 수 - imp 반환
	 */
	public int solution(int n, int[] lost, int[] reserve) {
		int imp = 0;
		int[] stud = new int[n+2];
		for (int i : lost) {
			stud[i]--;
		}
		for (int i : reserve) {
			stud[i]++;
		}
		for(int i = 1; i <= n; i++) {
			if(stud[i] == -1) {
				if(stud[i-1] == 1) {
					stud[i]++;
					stud[i-1]--;
				} else if (stud[i+1] == 1) {
					stud[i]++;
					stud[i+1]--;
				} else {
					imp++;
				}
			}
		}
		return n - imp;
	}
}
