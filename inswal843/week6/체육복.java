class Solution {
   /**
    * 풀이
    * 
    * 모든 학생이 체육복 1개씩 가진 상태에서 시작
    * 도난당한 학생은 -1, 여벌 가진 학생은 +1로 업데이트
    * 체육복이 없는 학생은 인접한 학생(앞 번호 우선)에게서 빌림
    * 체육복을 가진 학생 수를 카운트하여 반환
    * 
    * 시간 복잡도:
    * 전체 학생 n명을 순회하므로
    * O(n)
    */
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            students[i] = 1;
        }
        
        for (int l : lost) {
            students[l]--;
        }
        
        for (int r : reserve) {
            students[r]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (i > 1 && students[i - 1] == 2) {
                    students[i - 1]--;
                    students[i]++;
                }
                else if (i < n && students[i + 1] == 2) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
