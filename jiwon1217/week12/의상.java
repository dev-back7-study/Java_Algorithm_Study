package jiwon1217.week12;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    /**
     * 문제 풀이
     * 1. 의상 종류에 대한 개수 세기
     * 2. 해당 종류를 입는 경우, 해당 의상 종류에서 아무것도 선택하지 않는 경우 세기
     * 3. 모든 종류를 안입는 경우 -1
     * 시간 복잡도
     * N: 의상 수
     * O(N)
     */
    public int solution(String[][] clothes) {
        Map<String, Integer> typeCount = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        int combinations = 1;
        for (int count : typeCount.values()) {
            combinations *= (count + 1);
        }
        return combinations - 1;
    }
}
