import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> lostList = Arrays.stream(lost)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve)
            .boxed()
            .collect(Collectors.toList());
        
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        List<Integer> copy = new ArrayList<>(lostList);
        
        for(int i =0;i<copy.size();i++){
            int num = copy.get(i);
            if(reserveList.contains(num)){ // 자기 자신있으면 자기 거 입으면 됨.
                reserveList.remove(Integer.valueOf(num));
                lostList.remove(Integer.valueOf(num));
            }
        }
        
        answer+= n-lostList.size();
        System.out.println(answer);
        
        
        for(Integer lostStudent : lostList) {
            if(reserveList.contains(lostStudent - 1)){ // 자기 거 없으면 자기보다 작은 사람 거 우선 빌려보자.
                reserveList.remove(Integer.valueOf(lostStudent -1));
                answer++;
            } else if (reserveList.contains(lostStudent + 1)){ // 앞에 사람도 없으면 
                reserveList.remove(Integer.valueOf(lostStudent+ 1));
                answer++;
            }
        }
        
        return answer;
    }
}
