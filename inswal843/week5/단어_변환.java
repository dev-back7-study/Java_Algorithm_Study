import java.util.*;

class Solution {
    /**
     * 풀이
     * 
     * bfs를 이용하여 begin부터 target까지의 최소 변환 횟수를 탐색
     * 큐에는 현재 문자열(curStr)과 지금까지의 단계(curStep)를 저장
     * 방문하지 않은 단어와 현재 문자열을 비교해 하나만 다른 경우에만 큐에 넣어 탐색함
     * bfs이므로 처음 target에 도달했을 때의 curStep이 최소 변환 횟수임이 보장됨
     * target 단어에 도달하지 못하면 0을 반환
     * 
     * 시간 복잡도:
     * 단어의 길이 = n
     * words의 갯수 = m
     * 단어의 길이 만큼 비교(missMatched) -> O(n)
     * 지금 단어(curStr)와 모든 단어(words[i])를 비교 -> O(m * n)
     * 최악의 경우 이 비교를 단어의 갯수만큼 수행 -> O(m * m * n)
     * O(m^2 * n)
     */
  
    public class Node {
        public String curStr;
        public int curStep;

        public Node(String str, int step){
            curStr = str;
            curStep = step;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = begin.length();

        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            String curStr = curNode.curStr;
            int curStep = curNode.curStep;

            if(curStr.equals(target)) return curStep;

            for(int i=0; i < words.length; i++){
                if(!visited[i]){
                    int missMatched = 0;

                    for(int j = 0; j < n; j++){
                        if(curStr.charAt(j) != words[i].charAt(j)){
                            if(++missMatched > 1) break;
                        }
                    }
                    if(missMatched == 1){
                        visited[i] = true;
                        queue.offer(new Node(words[i], curStep+1));
                    }
                }

            }
        }
        return 0;
    }
}
