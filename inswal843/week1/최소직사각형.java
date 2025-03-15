class Solution {
    public int solution(int[][] sizes) {
        int max_w = 0, max_h = 0;

        for (int[] size : sizes) {
            max_w = Math.max(max_w, Math.max(size[0], size[1]));
            max_h = Math.max(max_h, Math.min(size[0], size[1]));
        }

        return max_w * max_h;
    }
}
