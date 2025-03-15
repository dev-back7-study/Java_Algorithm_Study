import java.util.Arrays;

public class 최소직사각형 {

    /**
     * 1. 완전탐색
     *
     * 모든 구간을 탐색하며 각 구간의 최대 최소 값의 최대를 기록
     *
     * 시간 복잡도: O(n)
     */

    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;

        for (int[] size : sizes) {
            int tempW = Math.max(size[0], size[1]);
            int tempH = Math.min(size[0], size[1]);

            w = Math.max(tempW, w);
            h = Math.max(tempH, h);
        }

        return w * h;
    }

    /**
     * 2. 정렬
     *
     * 정렬을 통해 가능한 가장 작은 두 값을 고름
     * 첫 번째 정렬: 작은 값이 첫 번재 요소, 큰 값이 두 번째 요소에 위치하도록 오름차순 정렬 -> 아래 정렬을 위한 선수 작업
     * 두 번째 정렬: 가로 길이 내림차순 정렬 -> 가장 큰 가로 길이 선택
     * 세 번째 정렬: 세로 길이 내림차순 정렬 -> 가장 큰 세로 길이 선택
     *
     * 시간 복잡도: O(NlogN)
     */

    /*public int solution(int[][] sizes) {
        for(int[] size : sizes){
            Arrays.sort(size);
        }
        Arrays.sort(sizes, (a,b) -> b[0] -a[0]);
        int w = sizes[0][0];

        Arrays.sort(sizes, (a,b) -> b[1] -a[1]);
        int h = sizes[0][1];

        return w*h;
    }*/

}
