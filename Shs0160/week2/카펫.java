class Solution {
    public int[] solution(int b, int y) {
        int wid = 0;
        int len = 0;
        for(int l=1; l<= (b+y)/l; l++){
            if((b+y)%l == 0){
                int w = (b+y)/l;
                if((w-2)*(l-2) == y){
                    wid = w;
                    len = l;
                    break;
                }
            }
        }
            
        
        return new int[]{wid, len};
    }
}
