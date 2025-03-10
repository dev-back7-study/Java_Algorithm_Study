import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    /**
     * dfs
     *
     * 가능한 모든 숫자를 만들어 소수인지 아닌지 판별
     * 만들어진 소수 Set에 저장후 결과 값으로 Size 반환
     * 문자열로 주어진 숫자를 int 배열로 변환후 사용
     *
     * 시간 복잡도: n은 숫자 길이
     * isPrime: O(√n)
     * getPrimes: O(n!)
     * 전체: O(n! * √n)
     */

    //소수 체크 메서드
    private boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i = 2; i*i <= n; i++){
            if(n % i == 0)
                return false;
        }

        return true;
    }

    //dfs 메서드
    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes){
        if(isPrime(acc)) primes.add(acc);

        for(int i = 0; i < numbers.length; i++){
            if(isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);

        return primes.size();
    }
}