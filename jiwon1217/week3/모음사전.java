package jiwon1217.week3;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    /**
     * 문제 풀이
     * 1. 모음 조합으로 만들 수 있는 모든 믄자열을 순서대로 list에 저장
     * 2. word가 저장된 인덱스 반환
     * 시간 복잡도
     * n: 모음의 길이
     * O(5^n)
     */
    private char[] temp = {'A', 'E', 'I', 'O', 'U'};
    private List<String> list = new ArrayList<>();

    public void dfs(StringBuilder str, String word) {
        list.add(str.toString());
        if (str.length() == 5) {
            return;
        }
        for (char c : temp) {
            str.append(c);
            dfs(str, word);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public int solution(String word) {
        int answer = 0;
        dfs(new StringBuilder(), word);

        return list.indexOf(word);
    }
}
