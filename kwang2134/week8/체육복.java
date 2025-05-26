package week8;

public class 체육복 {
    /** 풀이
     * 학생들의 체육복 정보를 배열에 입력
     * 체육복이 필요한 학생의 앞,뒤에 여분 체육복이 있다면 가져오고
     * 없다면 체육수업을 들을 수 없는 경우로 판단
     *
     * 시간 복잡도: O(n)
     *
     */

    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        int ans = n;

        for (int i : lost) {
            student[i - 1]--;
        }
        for (int i : reserve) {
            student[i - 1]++;
        }

        for (int i = 0; i < student.length; i++) {
            if (student[i] == -1) {
                if (i - 1 >= 0 && student[i - 1] == 1) {
                    student[i]++;
                    student[i - 1]--;
                } else if (i + 1 < n && student[i + 1] == 1) {
                    student[i]++;
                    student[i + 1]--;
                } else {
                    ans--;
                }
            }
        }

        return ans;
    }
}
