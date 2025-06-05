package week9;

import java.util.Arrays;

public class 구명보트 {
    /** 풀이
     *  몸무게 순으로 정렬 후 투 포인터 사용
     *  무거운 사람 + 가벼운 사람의 조합으로 최소한의 보트 사용
     *
     *  시간 복잡도: O(n log n) -> 정렬
     *  루프 자체는 O(n)이나 정렬에 O(n log n) 소요
     */

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while(left <= right) {
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }


        return answer;
    }
}
