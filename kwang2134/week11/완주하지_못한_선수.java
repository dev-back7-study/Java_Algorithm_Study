package week11;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    /**
     * 풀이
     * 완주한 선수를 map에 추가
     * 참여한 선수와 완주한 선수를 비교해 완주하지 못한 선수를 찾음
     *
     * 시간 복잡도: O(n)
     */
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String s : completion){
            map.merge(s, 1, Integer::sum);
        }
        for(String s : participant){
            if(!map.containsKey(s))
                return s;
            if(map.get(s) == 1)
                map.remove(s);
            else{
                map.replace(s, map.get(s) - 1);
            }
        }
        return "null";
    }
}
