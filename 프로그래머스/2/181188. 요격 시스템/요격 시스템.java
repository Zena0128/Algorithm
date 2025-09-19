import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (v1,v2) -> {
            if(v1[0]==v2[0]){
                return Integer.compare(v1[1],v2[1]);
            }else{
                return Integer.compare(v1[0],v2[0]);
            }
        });
        int[] dup = new int[]{0, 0};
        for (int[] target : targets){
            // System.out.println(Arrays.toString(target));
            if (target[0] >= dup[1]){
                dup = target;
                answer++;
            }
            else {
                dup[0] = Math.max(target[0], dup[0]);
                dup[1] = Math.min(target[1], dup[1]);
            }
        }
        return answer;
    }
}