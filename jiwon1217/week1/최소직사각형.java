package jiwon1217.week1;

public class 최소직사각형 {
    /**
     * 문제 풀이
     * 1. 길이가 긴 부분을 가로, 짧은 부분을 세로로 선택
     * 2. 가로, 세로의 max 값 찾기
     */
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0, h = 0;

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
                int tempW = Math.max(sizes[i][0], sizes[i][1]);
                int tempH = Math.min(sizes[i][0], sizes[i][1]);

                w = Math.max(w, tempW);
                h = Math.max(h, tempH);
            }
        }

        answer = w * h;
        return answer;
    }
}
