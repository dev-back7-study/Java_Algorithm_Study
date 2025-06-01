package week8;

public class 조이스틱 {
    /** 풀이 주석 참고
     *
     * 시간 복잡도: O(n)
     */

    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int leftRight = length - 1;

        for (int i = 0; i < length; i++) {
            // 해당 알파벳을 맞추기 위해 빠른쪽으로 이동 A -> B -> C 혹은 A -> Z -> Y
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 다음 순서가 A인 경우 조작할 필요가 없어 건너뜀
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            // next로 건너뛰기 위해 빠른쪽으로 이동 0 -> 1 -> 2 혹은 0 -> length-1 -> length-2
            leftRight = Math.min(leftRight, i + length - next + Math.min(i, length - next));
        }

        answer += leftRight;
        return answer;
    }
}
