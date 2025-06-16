import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * HashSet으로 폰켓몬의 종류 수를 구함
     * 선택 가능한 최대 종류 수는 min(종류 수, N/2)
     * 
     * 시간 복잡도:
     * O(n)
     */
    public int solution(int[] nums) {
        int maxSelect = nums.length / 2;
        
        HashSet<Integer> uniqueTypes = new HashSet<>();
        for (int type : nums) {
            uniqueTypes.add(type);
        }
        
        return Math.min(uniqueTypes.size(), maxSelect);
    }
    
}
