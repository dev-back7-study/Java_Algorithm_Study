package week3;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    /**
     * 풀이
     * 모음으로 만들 수 있는 최대 길이 5의 단어를 모두 만듬
     * 만들어진 단어의 인덱스를 반환하여 순서를 반환
     *
     * 시간 복잡도: O(5^l) l은 문자열의 길이
     * l이 5로 고정되어 있으므로 현재 문제에선 5^5 = 3125번 연산 고정적 수행
     */
    private static final char[] CHARS = "AEIOU".toCharArray();

    private void dfs(StringBuilder word, List<String> words){
        words.add(word.toString());

        if(word.length() == 5) return;

        for(char c : CHARS){
            StringBuilder newSb = new StringBuilder(word);
            dfs(newSb.append(c) ,words);
        }
    }
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        dfs(new StringBuilder(), words);
        return words.indexOf(word);
    }
}
