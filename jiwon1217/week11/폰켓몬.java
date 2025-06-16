package jiwon1217.week11;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    /**
     * 문제 풀이
     * 1. 폰켓몬 종류에 대한 set 생성
     * 2. set의 크기와 N/2마리 중 크기 비교
     * 시간 복잡도
     * N: 폰켓몬 수
     * O(N)
     */
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}
