package LimKangHyun.week2;

import java.util.*;

public class 모의고사 {
    /**
     * 1,2,3번 학생들의 정답 패턴 배열화
     * 정답과 1씩 증가하며 비교 (패턴의 길이가 다르므로 i % 배열길이)
     * 최고 점수만 answer리스트에 담고 int 배열로 반환
     */
    public int[] solution(int[] answers) {
        int[] cnt = new int[4];
        List<Integer> answer = new ArrayList<>();

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % 5]) {
                cnt[1] += 1;
            }
            if (answers[i] == b[i % 8]) {
                cnt[2] += 1;
            }
            if (answers[i] == c[i % 10]) {
                cnt[3] += 1;
            }
        }
        int max = Math.max(cnt[1], Math.max(cnt[2], cnt[3]));

        for(int i = 1; i <= 3; i++) {
            if (cnt[i] == max) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}