package week10;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    /**
     * 풀이
     * 각 차량의 나가는 지점을 기준으로 오름차순 정렬
     * 차량 경로가 last 위치의 카메라에 포착되지 않으면 해당 차량 나가는 지점에 새 카메라 설치
     *
     * 시간 복잡도: O(n log n)
     * 정렬 알고리즘의 시간 복잡도
     */
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        int last = Integer.MIN_VALUE;
        int count = 0;


        for(int[] route : routes){
            if(last >= route[0] && last <= route[1]) continue;
            last = route[1];
            count++;
        }

        return count;
    }
}
