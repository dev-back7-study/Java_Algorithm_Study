package jiwon1217.week2;

public class 모의고사 {
    /**
     * 문제 풀이
     * 1. 반복되는 패턴의 길이만큼 나머지 연산을 수행하며 맞춘 문제의 개수 세기
     * 2. 가장 많이 맞춘 사람의 수만큼 answer 배열 크기 지정
     * 3. 가장 많이 맞춘 사람이 누구인지 탐색
     *
     * 시간 복잡도
     * n: answers의 길이
     * O(n)
     */
    public int[] solution(int[] answers) {
        int[] answer;

        int[] person1 = {1, 2, 3, 4, 5};
        int cnt1 = 0;

        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int cnt2 = 0;

        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int person1Index = i % person1.length;
            int person2Index = i % person2.length;
            int person3Index = i % person3.length;

            if (answers[i] == person1[person1Index]) {
                cnt1++;
            }
            if (answers[i] == person2[person2Index]) {
                cnt2++;
            }
            if (answers[i] == person3[person3Index]) {
                cnt3++;
            }
        }

        int maxPerson = Math.max(cnt1, Math.max(cnt2, cnt3));
        int answerSize = 0;

        if (maxPerson == cnt1) {
            answerSize++;
        }
        if (maxPerson == cnt2) {
            answerSize++;
        }
        if (maxPerson == cnt3) {
            answerSize++;
        }

        answer = new int[answerSize];
        int i = 0;
        if (maxPerson == cnt1) {
            answer[i] = 1;
            i++;
        }
        if (maxPerson == cnt2) {
            answer[i] = 2;
            i++;
        }
        if (maxPerson == cnt3) {
            answer[i] = 3;
        }
        return answer;
    }
}
