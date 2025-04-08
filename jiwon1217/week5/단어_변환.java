package jiwon1217.week5;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
    /**
     * 문제 풀이
     * 1. BFS 수행하며 현재 문자열에서 한 개의 알파벳만 바꿔서 변환할 수 있는 단어들을 모두 Queue에 삽입 -> 변환 단계가 같은 단어 목록
     * 2. 현재 문자열이 target과 같으면 그 때의 변환 단계 반환
     * 시간 복잡도
     * n: 단어의 길이, m: words의 길이
     * O(m^2)
     */
    public boolean isConvertible(String cur, String next) {
        char[] curArr = cur.toCharArray();
        char[] nextArr = next.toCharArray();
        int differentCnt = 0;

        for (int i = 0; i < curArr.length; i++) {
            if (curArr[i] != nextArr[i]) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }

    public int bfs(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length + 1];
        int conversionStep = 0;

        Queue<String> q = new LinkedList<>();
        q.add(begin);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(target)) {
                    return conversionStep;
                }

                for (int j = 0; j < words.length; j++) {
                    String next = words[j];

                    if (!isConvertible(cur, next)) {
                        continue;
                    }
                    if (visit[j]) {
                        continue;
                    }
                    visit[j] = true;
                    q.add(next);
                }
            }
            conversionStep++;
        }
        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        return bfs(begin, target, words);
    }
}
