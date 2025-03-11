import java.util.*;

class Solution {
    
    // 숫자를 조합해서 소수가 되는 경우의 수를 return 
    // 일단 모든 숫자를 조합해보고 
    // 소수가 되는 수를 찾음 
    
    HashSet<Integer> h_num = new HashSet<>(); 
    int[] nums = {};
    int cnt = 0;
    
    //길이를 체크하고 숫자 사용여부 확인
    public void mixNum(String numbers, int[] check, String str){
        if(str.length() >= 1){
            int strToNum = Integer.parseInt(str);
            h_num.add(strToNum); 
        }
        
        for(int i = 0; i< numbers.length(); i++){
            if(check[i] == 0){
                check[i] = 1;
                str += numbers.charAt(i);
                mixNum(numbers, check, str);
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.deleteCharAt(sb.length() - 1);
                    str = sb.toString();
                }
                check[i] = 0;
            }
        }
        
    }

  //소수인지 확인!
    public void primeCheck(int n){
        if(n == 0){
            return;
        }
        else if(n == 1){
            return;
        }
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return;
        }
        cnt++;
    }
    
    public int solution(String str) {

        nums = new int[str.length()];
        
        mixNum(str, nums, "");
        
        for(int num : h_num){
            primeCheck(num);
        }
        
        return cnt;
        
        
    }
}
