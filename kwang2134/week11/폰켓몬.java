package week11;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    /**
     * 풀이
     * 모든 폰켓몬을 set 에 담아 중복 제거
     * set 에 들어있는 폰켓몬 수가 N/2 보다 작다면 폰켓몬의 종류 수 반환
     * N/2보다 크다면 N/2를 반환
     *
     * 시간 복잡도: O(n)
     */
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        if(set.size() > nums.length/2)
            return nums.length/2;

        return set.size();
    }
}
