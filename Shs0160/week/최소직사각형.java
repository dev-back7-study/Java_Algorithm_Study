import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        
        // 완전 탐색
        // 모든 명함이 다 들어갈 수 있는 가로x세로를 찾아야함
        // 1. for문으로 가로세로의 길이를 구한다.
        // 2. 세로가 가로보다 길면 가로와 세로의 값을 바꾼다.
        
        int arr_len = sizes.length;
        int[] wid = new int[arr_len];
        int[] len = new int[arr_len];
        
        for(int i = 0; i < arr_len; i++){
            wid[i] = sizes[i][0];
            len[i] = sizes[i][1];
            if(wid[i] > len[i]){
                int n = wid[i];
                wid[i] = len[i];
                len[i] = n;
            }
        }
        Arrays.sort(wid);
        Arrays.sort(len);

        return wid[arr_len-1] * len[arr_len-1];
    }
}
