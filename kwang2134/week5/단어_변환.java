package week5;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
    /**
     * 풀이
     * 최소 단계 -> bfs
     * 단어를 단계별로 변환 가능한 모든 단어로 변환하며 진행 -> 레벨별 탐색
     * isConvertable 메서드를 통해 단어 변환 가능 여부 검사
     *
     * 시간 복잡도: O(n^2 * m)
     * isConvertable: O(m) -> m는 문자열 길이
     * 각 단어마다 검사를 수행 O(n * m)
     * 최악의 경우 모든 단어 처리 O(n * n * m)
     */


    /**
     * 단어의 각 상태를 State 객체를 통해 관리하는 방법
     *
     * 객체 내부에 현재 단어와 변환 횟수를 기록
     * 변환 횟수를 외부에서 따로 기록하지 않음
     * 목표 단어를 발견하면 같이 보관하던 횟수를 반환
     */

    private static class State{
        public final String word;
        public final int step;

        private State(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    private int bfsWithState(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];
        Queue<State> que = new LinkedList<>();
        que.add(new State(begin, 0));

        while(!que.isEmpty()){
            State state = que.poll();

            if(state.word.equals(target)){
                return state.step;
            }

            for(int i = 0; i < words.length; i++){
                String next = words[i];
                if(!isConvertable(state.word, next)){
                    continue;
                }
                if(isVisited[i])
                    continue;
                isVisited[i] = true;
                que.add(new State(next, state.step + 1));
            }
        }

        return 0;

    }

    /**
     * 라운드별 수행 방법
     *
     * 라운드(레벨)를 나타낼 변수를 사용
     * 각 라운드마다 동일한 레벨의 모든 노드를 뽑아 처리하고 라운드 값을 증가
     * 목표 단어를 발견하면 해당 라운드 값을 최소 변환 수로 반환
     */
    private int bfs(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];
        Queue<String> que = new LinkedList<>();
        que.add(begin);

        int round = 0;

        while(!que.isEmpty()){
            int size = que.size();

            for (int i = 0; i < size; i++) {
                String word = que.poll();

                if(word.equals(target)){
                    return round;
                }

                for (int j = 0; j < words.length; j++) {
                    String next = words[j];

                    if(!isConvertable(word, next)) continue;
                    if(isVisited[j]) continue;

                    isVisited[j] = true;
                    que.add(next);
                }
            }

            round++;
        }
        return 0;
    }

    private boolean isConvertable(String src, String dst){
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        int diff = 0;
        for(int i = 0; i < srcArr.length; i++){
            if(srcArr[i] != dstArr[i]) diff++;
        }
        return diff == 1;
    }


    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
//        return bfsWithState(begin, target, words);
    }
}
