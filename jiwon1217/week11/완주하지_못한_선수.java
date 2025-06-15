package jiwon1217.week11;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    /**
     * 문제 풀이
     * 1. 참가자 map 생성
     * 2. 완주자에 대해 value 1 감소
     * 시간 복잡도
     * N: 참가자 수
     * O(N)
     */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
