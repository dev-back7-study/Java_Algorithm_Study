package jiwon1217.week9;

import java.util.Arrays;

public class 구명보트 {
    /**
     * 문제 풀이
     * 1. 정렬 후 투포인터 탐색을 통해 최적의 조합 생성
     * 시간 복잡도
     * N: people의 길이
     * 정렬: O(N log N)
     * 투 포인터 순회: O(N)
     * 전체: O(N log N)
     */
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                answer++;
                l++;
                r--;
            } else {
                answer++;
                r--;
            }
        }
        return answer;
    }
}
