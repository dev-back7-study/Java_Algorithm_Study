import java.util.*;

class Solution {
    
    Set<Integer> permNums = new HashSet<>();
    
    public void permutation(String[] number, int depth, int n, int r) {
        
        if(depth == r) {
            int temp = Integer.parseInt(String.join("", number).substring(0,r));
            if(isPrimeNumber(temp)){
                permNums.add(temp);
            }
            return;
        }
        
        for(int i=depth;i<n;i++){
            swap(number, depth, i);
            permutation(number, depth+1, n, r);
            swap(number, depth, i);
        }
    }
    
    public void swap(String[] number, int i, int j) {
        String temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
    
    public boolean isPrimeNumber(int num) {
        
        if (num<2) {
            return false;
        } else if (num == 2) {
            return true;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        
        return true;
        
    }
    
    
    public int solution(String numbers) {
        int answer = 0;
        
        String[] nums = numbers.split("");
        
        for(int i=0;i<nums.length;i++){
            int temp = Integer.parseInt(nums[i]);
            if(isPrimeNumber(temp)){
                permNums.add(temp);
            }
        }
        
        for(int i=2;i<=nums.length;i++){
            permutation(nums, 0, nums.length, i);
        }
        
        System.out.println(permNums.toString());
        
        answer = permNums.size();
        
        return answer;
    }
    

}
