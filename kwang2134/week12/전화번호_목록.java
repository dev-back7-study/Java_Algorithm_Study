package week12;

public class 전화번호_목록 {
    /**
     * 풀이
     * 트라이(Trie) 알고리즘 사용
     * 주어진 번호로 트리 기반의 트라이 구조를 구현
     * end 태그가 true 라면 해당 노드까지의 경로가 존재하는 것
     *
     * 시간 복잡도: O(N × M)
     * N: 전화번호의 개수
     * M: 전화번호의 평균 길이
     */
    private class Trie {
        public Trie[] next;
        public boolean end;

        public Trie() {
            this.next = new Trie[10];
            this.end = false;
        }
    }

    public boolean solution(String[] phone_book) {
        Trie root = new Trie();

        for (String s : phone_book) {
            Trie pointer = root;

            for (char c : s.toCharArray()) {
                if (pointer.next[c - '0'] == null) {
                    pointer.next[c - '0'] = new Trie();
                }
                pointer = pointer.next[c - '0'];

                if (pointer.end) {
                    return false;
                }
            }

            pointer.end = true;

            for (Trie trie : pointer.next) {
                if (trie != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
