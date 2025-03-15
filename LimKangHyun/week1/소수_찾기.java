package LimKangHyun.week1;

import java.util.*;

class 소수_찾기 {
    /**
     * dfs 탐색으로 문자열의 첫번째 문자부터 depth별로 tempN들을 만들어 set에 삽입
     * isPrime으로 set 원소를 소수판별하고, 소수이면 answer 1씩 증가
     *
     */
    boolean[] visit = new boolean[7];
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        for(int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, "", i);
        }
        for (int i : set) {
            if(isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }
    private void dfs(String numbers, String tempN, int depth) {
        if (tempN.length() == depth) {
            set.add(Integer.parseInt(tempN));
        }
        for(int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                tempN += numbers.charAt(i);
                dfs(numbers, tempN, depth);
                visit[i] = false;
                tempN = tempN.substring(0, tempN.length() - 1);
            }
        }
    }
    private boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0 || n < 2) {
            return false;
        }
        for(int i = 3; i * i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
