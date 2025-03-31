package LimKangHyun.week3;

public class 모음사전 {
    /**
     * 시간복잡도(BigO) : O(3906) -> 빈문자열 + 등비수열(5 + 5^2 + 5^3 + 5^4 + 5^5)
     * dfs로 word를 찾다가 sb가 word와 같다면 cnt를 answer에 저장하고 탐색 종료
     */
    private static String vowel = "AEIOU";
    private static int cnt = 0;
    private static int answer = 0;

    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(word, sb);
        return answer;
    }
    private static void dfs(String word, StringBuilder sb) {
        if (sb.toString().equals(word)) {
            answer = cnt;
            return;
        }
        if (sb.length() == vowel.length()) {
            return;
        }
        for (char c : vowel.toCharArray()) {
            sb.append(c);
            cnt++;
            dfs(word, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}