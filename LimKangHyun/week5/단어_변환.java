package LimKangHyun.week5;

import java.util.*;

public class 단어_변환 {
    /**
     * bfs 시간복잡도(BigO) : O(N)
     * 전체코드 시간복잡도(BigO) : O(N^2 * L) -> L은 단어 길이
     * 단어에서 한 글자만 다른 단어들을 찾아 큐에 삽입
     * (correct == word.length - 1)인경우 큐 삽입 및 방문처리(visit[i] = true)
     * target과 같은 단어인 경우 count 반환, target과 같은단어가 안나오고 종료하면 0 반환
     */
    static class Case {
        String word;
        int count;

        Case(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    private static int bfs(String begin, String target, String[] words) {
        Queue<Case> queue = new LinkedList<>();
        boolean[] visit = new boolean[words.length];
        queue.offer(new Case (begin, 0));

        while(!queue.isEmpty()) {
            Case current = queue.poll();
            String word = current.word;
            int count = current.count;

            if(word.equals(target)) return count;

            for(int i = 0; i < words.length; i++) {
                if(!visit[i]) {
                    int correct = 0;
                    for(int j = 0; j < word.length(); j++) {
                        if(word.charAt(j) == words[i].charAt(j)) {
                            correct++;
                        }
                    }
                    if(correct == word.length() - 1) {
                        queue.offer(new Case(words[i], count+1));
                        visit[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}