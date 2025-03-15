package LimKangHyun.week1;

class 최소직사각형 {
    /**
     * sizes배열의 각 원소의 배열에서 큰 수를 w, 작은 수를 h로 만들고
     * w중 가장 큰 수를 지갑의 w(walletW), h중 가장 큰 수를 지갑의 h(walletH)
     * answer = walletW * walletH
     *
     */
    public int solution(int[][] sizes) {
        int answer = 0;
        int walletW = 0;
        int walletH = 0;
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            walletW = Math.max(walletW, w);
            walletH = Math.max(walletH, h);
        }
        answer = walletW * walletH;
        return answer;
    }
}