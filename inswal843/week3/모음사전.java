public class Solution {
    /**
     * 풀이
     * 가능한 모든 단어를 dfs로 사전순 생성
     * 만들어진 단어가 목표와 같으면 몇번째인지 저장하고 return
     * 단어의 길이가 5 이거나 이미 답을 찾은경우 return
     * 아닌경우 알파벳 순서에 맞게 계속 dfs수행
     * 
     * 답을 찾은 경우를 저장해 탐색이 필요 없어진 경우 return하여
     * 시간 복잡도의 개선을 시도해봤다.
     */
    private String[] alpha = {"A", "E", "I", "O", "U"};
    private int cnt = 0;
    private int ans = 0;
    private boolean found = false;

    public int solution(String word) {
        dfs(new StringBuilder(), word);
        return ans;
    }

    private void dfs(StringBuilder sb, String target) {
        if (sb.toString().equals(target)) {
            ans = cnt;
            found = true;
            return;
        }
        
        if (sb.length() == 5 || found) return;

        for (int i = 0; i < alpha.length; i++) {
            sb.append(alpha[i]);
            cnt++;
            dfs(sb, target);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
