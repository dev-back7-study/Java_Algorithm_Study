import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * 차량의 진출 지점을 기준으로 오름차순 정렬
     * 첫 차량의 진출 지점에 카메라 설치
     * 현재 카메라 위치가 차량의 진입 지점보다 앞이면 새 카메라 필요
     * 새 카메라는 해당 차량의 진출 지점에 설치
     * 모든 차량을 커버할 때까지 반복
     * 
     * 시간 복잡도:
     * 정렬 O(n log n)
     *
     */
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cameras = 0;
        int lastCamera = -30001;
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if (lastCamera < start) {
                cameras++;
                lastCamera = end;
            }
        }
        
        return cameras;
    }
}
