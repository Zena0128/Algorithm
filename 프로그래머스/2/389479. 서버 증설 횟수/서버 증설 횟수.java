import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] available = new int[24];
        Arrays.fill(available, m-1);
        
        for (int i=0;i<24;i++){
            if (players[i] > available[i]){
                int n = (int) Math.ceil((double)(players[i]-available[i])/m);
                // System.out.println(i+" "+n);
                answer += n;
                for (int j=0;j<k;j++){
                    if (i+j < 24){
                        available[i+j] += m*n;
                    }
                }
                // System.out.println(Arrays.toString(available));
            }
        }
        return answer;
    }
}