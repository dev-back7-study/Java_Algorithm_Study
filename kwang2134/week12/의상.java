package week12;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    /**
     * 풀이
     * 모든 의상을 카테고리 별로 개수를 체크
     * 입지 않는 경우를 포함해 카테고리별 + 1
     * 모든 조합을 구하기 위해선 모든 경우의 수를 곱하고 아무것도 입지 않는 경우 1가지를 제외 answer - 1
     *
     * 시간 복잡도: O(N)
     */
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesMap.merge(clothe[1], 1, Integer::sum);
        }

        int answer = 1;

        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
