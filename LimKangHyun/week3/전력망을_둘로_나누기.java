package LimKangHyun.week3;

import java.util.*;

public class 전력망을_둘로_나누기 {
    /**
     * union-find 풀이 시간복잡도(BigO) : O(n^2)
     * union-find 알고리즘 시간복잡도 : O(α(n))
     * 루트노드를 둘로 나누기 위해 unionByRank 사용
     * union-find에서 rank를 사용해 바로 루트노드를 찾도록 함
     * 각 노드의 부모노드를 비교하여 find(parent, parent[1]) 즉, 노드 1의 루트노드와 같은 루트노드를 가지고 있는 숫자 카운트
     *
     * DFS 풀이 시간복잡도(BigO) : O(n^2)
     * dfs 알고리즘 시간복잡도 : O(n)
     */
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            int[] parent = new int[n+1];
            int[] rank = new int[n+1];
            for(int j = 1; j < n+1; j++) {
                parent[j] = j;
            }
            for(int j = 0; j < n - 1; j++) {
                if (i != j) {
                    unionByRank(parent, rank, wires[j][0], wires[j][1]);
                }
            }
            System.out.println(Arrays.toString(parent));
            int count = (int) Arrays.stream(parent)
                    .skip(1) // 0번째 인덱스를 제외하고 (1번부터 n번까지 체크)
                    .filter(num -> find(parent, num) == find(parent, 1))
                    .count();
            System.out.println(count);

            answer = Math.min(answer, (Math.abs((n - count) - count)));
        }

        return answer;
    }

    private static int find(int[] parent, int x) {
        if(parent[x] != x) {
            x = find(parent, parent[x]);
        }
        return parent[x];
    }

    // 부모를 둘로 나누기 위해 unionByRank
    private static void unionByRank(int[] parent, int[] rank, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        if(x != y) {
            if(rank[x] > rank[y]) {
                parent[y] = x;
            } else if( rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[y] = x;
                rank[x]++;
            }

        }
    }
}

//public class 전력망을_둘로_나누기  {
//
//    private static List<Integer>[] list;
//
//    public int solution(int n, int[][] wires) {
//        int answer = Integer.MAX_VALUE;
//
//        for(int i = 0; i < n; i++) {
//            list = new ArrayList[n+1];
//            for(int j = 0; j < list.length; j++) {
//                list[j] = new ArrayList<>();
//            }
//            boolean[] visit = new boolean[n+1];
//            for(int j = 0; j < n - 1; j++) {
//                if (i != j) {
//                    list[wires[j][0]].add(wires[j][1]);
//                    list[wires[j][1]].add(wires[j][0]);
//                }
//            }
//            dfs(list, 1, visit);
//            int count = 0;
//            for(int j = 0; j < visit.length; j++) {
//                if(visit[j]) count++;
//            }
//            answer = Math.min(answer, (Math.abs((n - count) - count)));
//        }
//
//        return answer;
//    }
//
//    private static void dfs(List<Integer>[] list, int start, boolean[] visit) {
//        for(int i : list[start]) {
//            if(!visit[i]) {
//                visit[i] = true;
//                dfs(list, i, visit);
//            }
//        }
//    }
//}