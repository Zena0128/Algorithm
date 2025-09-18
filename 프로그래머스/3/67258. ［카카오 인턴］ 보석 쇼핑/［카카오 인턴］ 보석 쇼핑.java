import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        int[] answer = new int[]{1, n};

        int left = 0, right = 0;
        HashMap<String, Integer> jewels = new HashMap<>();
        for (String gem:gems){
            jewels.putIfAbsent(gem, 0);
        }
        jewels.replace(gems[0], 1);
        int kind = jewels.keySet().size(); // 보석의 종류(가짓수)
        Queue<String> queue = new LinkedList<>();
        queue.add(gems[0]);
        Set<String> jewelKinds = new HashSet<>();
        jewelKinds.add(gems[0]);
        // System.out.println(kind);
        if (kind == 1){
            return new int[]{1, 1};
        }
        while (left<n-1&&right<=n-1){
            String g = gems[right];
            // System.out.println(jewelKinds);
            // System.out.println(jewels);
            // System.out.println(queue);
            // 모든 보석을 모았다면
            if (jewelKinds.size() >= kind){
                // 현재 답보다 길이가 더 짧다면 답 갱신
                if (right-left < answer[1]-answer[0]){
                    answer = new int[]{left+1, right+1};
                }
                
                // left를 오른쪽으로 옮겨서 살 보석 개수 줄이기
                if (left < right && left < n-1){
                    left++;
                    g = queue.remove();
                    jewels.replace(g, jewels.get(g)-1);
                    if (jewels.get(g) == 0){ // 해당 종류의 보석이 더 이상 없다면 세트에서 빼기
                        jewelKinds.remove(g);
                    }
                    
                }
            } else{ // 보석의 종류가 부족하다면 right를 오른쪽으로 옮겨서 보석 더 구매하기
                right++;
                if (right == n){
                    return answer;
                }
                g = gems[right];
                queue.add(g);
                jewels.replace(g, jewels.get(g)+1);
                jewelKinds.add(g);
            }
        }
        return answer;
    }
}