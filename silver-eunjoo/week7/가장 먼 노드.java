import java.util.*;

class Solution {
    
    public int dijkstra(int n, List<Integer>[] nodeList){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int i=1;i<=n;i++){
            
            int minNode = -1;
            int minDist = Integer.MAX_VALUE;
            
            for(int j=1;j<=n;j++){
                if(!visited[j] && dist[j] < minDist){
                    minNode = j;
                    minDist = dist[j];
                    // break 가 있으면 왜 안될까 생각했는데, 제일 짧은 distance를 찾아야하기 때문이었다.. ! 
                }
            }
            
            if(minNode == -1){
                break;
            }
            
            visited[minNode] = true;
            
        
            for(int j=1;j<=nodeList[minNode].size();j++){
                int nodeNum = nodeList[minNode].get(j-1);
                if(!visited[nodeNum] && dist[nodeNum] > dist[nodeNum] + 1){
                    dist[nodeNum] = dist[minNode] + 1;
                }
            }
        }
        
        int maxDist = -1;
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(maxDist < dist[i]){
                answer = 0;
                maxDist = dist[i];
                answer++;
            } else if(maxDist == dist[i]){
                answer++;
            }
        }
        
        return answer;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int edgeNum = edge.length;
        
        
        ArrayList<Integer>[] nodeList = new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++){
            nodeList[i] = new ArrayList<Integer>();
        }
        
        // graph 만들기
        for(int i=0;i<edgeNum;i++){
            nodeList[edge[i][0]].add(edge[i][1]);
            nodeList[edge[i][1]].add(edge[i][0]);
        }
        
        answer = dijkstra(n, nodeList);
        
        return answer;
    }
}
