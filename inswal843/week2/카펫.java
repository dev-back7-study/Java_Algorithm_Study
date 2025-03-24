class Solution {
    /**
     * brown과 yellow를 더해 모든 타일의 갯수를 구함
     * 
     * 높이가 너비보다 무조건 짧거나 같으므로 최소높이 3부터
     * total의 제곱근까지 반복하며 높이를 찾음 
     * (최소갯수가 갈색 8개 노랑 1개 이므로 높이는 3미만 불가능)
     * 
     * 너비와 높이에 따른 노랑 타일의 갯수가 yellow와 동일한지 확인
     * 맞으면 정답을 반환
     */
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {
                int width = total / height;
                if ((width - 2) * (height - 2) == yellow) { 
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{};
    }
}
