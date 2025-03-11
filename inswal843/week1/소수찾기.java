import java.util.*;

class Solution {
    /**
     *
     * 입력된 문자열을 하나씩 나누어 List로 저장
     * 반복문을 이용해 완성된 숫자의 길이를 순차적으로 늘려가며 만들수 있는 모든 숫자 생성
     * 소수 판별 후 set에 저장
     * set의 크기를 반환
     */
    public int solution(String numbers) {
        List<String> nums = Arrays.asList(numbers.split(""));
        Set<Integer> primeSet = new HashSet<>();

        for (int length = 1; length <= nums.size(); length++) {
            findPrimes(primeSet, new boolean[nums.size()], nums, length, 0, "");
        }
        return primeSet.size();
    }

    public void findPrimes(Set<Integer> primeSet, boolean[] visited, List<String> nums, int limit, int curLength, String curNumber) {
        if (curLength == limit){
            int number = Integer.parseInt(curNumber);
            if(isPrime(number)){
                primeSet.add(number);
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (!visited[i]){
                    visited[i] = true;
                    findPrimes(primeSet, visited, nums, limit, curLength+1, curNumber + nums.get(i));
                    visited[i] = false;
                }
            }
        }
    }

    public boolean isPrime(int number) {
        if(number < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
