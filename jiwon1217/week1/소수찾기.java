package jiwon1217.week1;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    /**
     * 문제 풀이
     * 1. numbers에 포함된 문자로 만들 수 있는 모든 수 나열 -> 순열
     * 2. 소수 판별
     * 3. Set에 추가 -> Set의 크기 = 소수의 개수
     */
    public static boolean[] visit = new boolean[10];
    public static Set<Integer> primeSet = new HashSet<>();

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void permutation(String numbers, String result, int size) {
        if (result.length() == size) {
            int num = Integer.parseInt(result);
            if (isPrime(num)) {
                primeSet.add(num);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                result += numbers.charAt(i);
                permutation(numbers, result, size);
                visit[i] = false;
                result = result.substring(0, result.length() - 1);
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, "", i);
        }
        answer = primeSet.size();
        return answer;
    }
}
