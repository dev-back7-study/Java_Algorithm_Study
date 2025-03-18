package LimKangHyun.week2;

public class 카펫 {
    /**
     * yellow격자의 가로 + 세로 길이는 (카펫 외곽의 격자 개수 / 2) - 2;
     * 카펫의 가로길이가 세로길이보다 길거나 같기때문에 yellow 세로길이는 yellow의 제곱근보다 클 수 없다.
     * height를 1부터 yellow의 제곱근까지 1씩 증가시키며 탐색
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yellowWidthPlusHeight = (brown / 2) - 2;

        for(int height = 1; height <= Math.sqrt(yellow); height++) {
            int width = yellowWidthPlusHeight - height;
            if(height * width == yellow) {
                answer[0] = width + 2;
                answer[1] = height + 2;
            }
        }
        return answer;
    }
}