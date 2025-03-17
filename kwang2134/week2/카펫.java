package week2;

public class 카펫 {
    /**
     * 풀이
     * 주어진 노란색 카펫의 개수로 사각형을 만드는 경우를 구한 뒤
     * 전체 카펫의 개수에서 노란색 카펫의 개수를 뺐을 때 갈색 카펫의 수가 나오는지 체크
     *
     * x = 노란색 카펫의 세로 개수
     * y = 노란색 카펫의 가로 개수
     * for 문의 범위를 노란색 카펫의 제곱근 까지 설정
     * -> y(가로)가 항상 x(세로)보다 커야하는데 제곱근을 넘어가면 x가 y보다 커짐
     *
     * 노란색 카펫의 개수로 갈색 카펫의 개수를 구하기 위해선 노란색 카펫 가로, 세로에 +2를 해줌
     *  -> 갈색 카펫의 노란색 카펫보다 위, 아래 한 줄씩 양 옆으로 한 줄씩 총 가로 세로 2줄씩 더 있기 때문
     *
     * 시간 복잡도: O(√n)
     */
    public int[] solution(int brown, int yellow) {

        for (int x = 1; x <= Math.sqrt(yellow); x++) {
            if (yellow % x == 0) {
                int y = yellow / x;

                if ((x + 2) * (y + 2) - x * y == brown) {
                    return new int[]{y + 2, x + 2};
                }
            }
        }

        return new int[0];
    }
}
