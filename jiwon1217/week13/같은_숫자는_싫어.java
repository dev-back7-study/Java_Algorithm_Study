package jiwon1217.week13;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
    /**
     * 문제 풀이
     * 1. arr에서 연속된 숫자가 중복되는 부분을 제거하고, 첫 번째 값만 남김
     * 시간 복잡도
     * N: 배열 arr의 크기
     * O(N)
     */
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                list.add(arr[i]);
            }
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
