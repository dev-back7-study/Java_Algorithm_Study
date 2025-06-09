package jiwon1217.week10;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    /**
     * 문제 풀이
     * 1. 진출 지점을 기준으로 정렬
     * 2. 설치된 카메라 위치 탐색
     * 3. 정렬된 차량 경로를 순회하면서,
     *      만약 현재 차량의 진입 지점 > 마지막 카메라 위치이면,
     *          겹치는 구간이 없으므로 새로운 카메라 설치가 필요합니다.
     *          이 차량의 진출 지점에 카메라를 설치합니다.
     * 시간 복잡도
     * N: 차량의 수
     * O(N log N)
     */
    public int solution(int[][] routes) {
        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];

            if (cameraPosition < entry) {
                answer++;
                cameraPosition = exit;
            }
        }
        return answer;
    }
}
