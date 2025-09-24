import java.io.*;
import java.util.*;
public class Main {
        static int n;
        static int answer;
        static void calc(int idx, int[] weights, boolean[] visited, int deletedCnt, int tmp){

            int left = 0;
            int right = 0;
            for (int i=idx-1;i>=0;i--){
                if (!visited[i]){
                    left = weights[i];
                    break;
                }
            }
            for (int i=idx+1;i<n;i++){
                if (!visited[i]){
                    right = weights[i];
                    break;
                }
            }
            
            if (left==0 || right==0) {
                return;
            }
            tmp += left*right;
            // System.out.println(Arrays.toString(visited));
            // System.out.println("idx: " + idx + " left: " + left + " right: " + right + " tmp: " + tmp+ " deletedCnt: "+deletedCnt);
            if (deletedCnt == n-2){
                answer = Math.max(answer, tmp);
                return;
            }
            for (int i=1;i<n-1;i++){
                if (!visited[i]) {
                    visited[i] = true;
                    calc(i, weights, visited, deletedCnt+1, tmp);
                    visited[i] = false;
                }
            }
            tmp -= left*right;

        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] weights = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i=0;i<n;i++){
                weights[i] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);

            for (int i=1;i<n-1;i++){
                int tmp = 0;
                visited[i] = true;
                calc(i, weights, visited, 1, tmp);
                visited[i] = false;
            }

            System.out.println(answer);
            
        }
}