package week2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 모의고사 {
    /**
     * 풀이
     * 수포자 3명의 찍는 패턴을 상수로 정의
     * answers 배열을 순회하며 수포자들의 패턴으로 맞춘 문제 개수를 저장 (나머지 연산으로 찍기 패턴에 접근)
     * 수포자 3명의 정답 개수 중 가장 높은 개수를 구해 동일하게 맞춘 수포자들을 배열에 담아 반환
     *
     * 반환 과정과 최댓값 연산 stream 사용
     * stream 사용 시 편하긴 하나 성능은 그닥...
     *
     * 시간 복잡도: O(n)
     * 2중 for 문을 사용하긴 하지만 내부 for 문이 고정 길이 3으로 answers 에 대한 시간 복잡도만 적용
     */
    private static final int[][] RULES = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];

        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if (answers[i] == RULES[j][i % RULES[j].length]) {
                    corrects[j]++;
                }
            }
        }

        int maxCorrects = Arrays.stream(corrects).max().getAsInt();

        return IntStream.range(0,3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }
}
