import java.io.*;
import java.util.*;
public class Main {
        static int answer;
        static int[][] map;
        static int n;
        static void backtracking(int start, int depth, boolean[] visited, int tmp, int backward){
            visited[start] = true;
            // System.out.println("depth: "+depth+" start: "+start+" visited: "+Arrays.toString(visited)+" isFront: "+isFront+" tmp: "+tmp+" backward: "+backward);

            if (depth == n-1){
                visited[start] = false;
                if (map[start][backward] > 0){
                    answer = Math.min(answer, tmp+map[start][backward]);
                    return;
                }
            }
            else {
                for (int i=0;i<n;i++){
                    if (!visited[i] && map[start][i] > 0){
                        backtracking(i, depth+1, visited, tmp+map[start][i], backward);
                    }
                }
            }
            visited[start] = false;
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            for (int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            answer = Integer.MAX_VALUE;
            for (int i=0;i<n;i++){
                backtracking(i, 0, visited, 0, i);
            }
            
            System.out.print(answer);
        }
}
