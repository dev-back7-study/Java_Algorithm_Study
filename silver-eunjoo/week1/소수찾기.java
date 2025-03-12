import java.util.*;

class Solution {
    
    // 함수에서 이용할 수 있도록 전역변수로 두었음.
    // permNums는 주어진 숫자로 나올 수 있는 모든 숫자들을 담을 곳 (순열 이용)
    List<String> permNums = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;
        
        // numbers 한자리 수로 다 자르고 배열에 담았음.
        String[] nums = numbers.split("");
        
        // 배열에 있는 한 자리 수들을 순열 
        for(int i =0;i<nums.length;i++){
            permNums.add(nums[i]);
        }
        
        // nPr (n : 가지고 있는 수의 개수 r : 2부터 n까지)
        for(int i=2;i<=nums.length; i++){
            permutation(nums, 0, nums.length, i);    
        }
        
        // 같은 수가 2개 있을 때, 110, 110 이렇게 두 개 만들어짐. 그래서 중복 제거
        List<String> uniquePermNums = new ArrayList<>(new HashSet<>(permNums));
        
        // 조합한 숫자가 소수인지 판단하기 -> isPrimeNumber -> 나올 수 있는 수들을 List에 담음.
        List<Integer> permNumsInteger = isPrimeNumber(uniquePermNums);
        
        // 정수로 바뀌면서 011, 11 => 11, 11로 중복적으로 저장되어있기 때문에 중복 제거
        List<Integer> uniqueInteger = new ArrayList<>(new HashSet<>(permNumsInteger));
        
        answer = uniqueInteger.size();
        
        return answer;
    }

    // 순열 함수
    public void permutation(String[] nums, int depth, int n, int r) {
        if(depth == r){
            permNums.add(String.join("", nums).substring(0,r));
            return;
        }
        
        for (int i=depth; i<n; i++) {
        swap(nums, depth, i);
        permutation(nums, depth + 1, n, r);
        swap(nums, depth, i);
        }
    }
    
    // 문자열 위치 변경 swap 함수
    public void swap(String[] nums, int depth, int i) {
        String temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }
    
    
    // 소수인지 판단하는 함수
    public List<Integer> isPrimeNumber(List<String> uniquePermNums) {
        
        List<Integer> nums = new ArrayList<>();
        
        for (String uniqueNum : uniquePermNums) {
            
            int i = 2;
            int num = Integer.parseInt(uniqueNum); // 숫자를 정수로 변환해줌. 이 때 011, 11가 똑같이 11로 변환
            
            if (num == 1) {
                continue;
            } else {
                for(;i<num;i++){
                    if(num%i == 0) {
                        break;
                    }
                }
            }
                
            if(i==num) {
                nums.add(num);
                // 숫자가 소수면 List에 담아준다.
            }
        }
        
        return nums;
         
    }
}
