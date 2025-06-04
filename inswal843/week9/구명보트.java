import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * 사람들의 몸무게를 오름차순으로 정렬
     * 가장 가벼운 사람과 가장 무거운 사람을 짝지어 태우기 시도
     * 모든 사람을 태울 때까지 반복
     * 
     * 시간 복잡도:
     * 길이는 n이여도 정렬에 소요되는 시간이 O(n log n)
     * O(n log n)
     */
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }
            else {
                right--;
            }
            
            boats++;
        }
        
        return boats;
    }
}
