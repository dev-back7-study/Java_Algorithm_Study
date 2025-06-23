package jiwon1217.week12;

import java.util.Arrays;

public class 전화번호_목록 {
    /**
     * 문제 풀이
     * 1. 전화번호부 정렬
     * 2. 전화번호부를 탐색하며 접두어 판단
     * 시간 복잡도
     * N: 전화번호 수
     * O(N log N)
     */
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
