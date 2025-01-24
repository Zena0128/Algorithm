import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] prices = new int[n];
        int m = Integer.parseInt(st.nextToken());
        int[] weights = new int[m+1];
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        int occupied = 0;
        int[] parked = new int[n];

        for (int i=0;i<n;i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0;i<m;i++) {
            weights[i+1] = Integer.parseInt(br.readLine());
        }

        for (int i=0;i<2*m;i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp < 0) {
                for (int j=0;j<n;j++) {
                    if (parked[j] == temp*-1){
                        if (q.size()>0) {
                            parked[j] = q.poll();
                            ans += prices[j] * weights[parked[j]];
                        } else {
                            parked[j] = 0;
                            occupied--;
                        }
                        break;
                    }
                }
            }
            else {
                if (occupied == n) {
                    q.add(temp);
                } else {
                    for (int j=0;j<n;j++) {
                        if (parked[j] == 0){
                            parked[j] = temp;
                            ans += prices[j] * weights[temp];
                            occupied++;
                            break;
                        }
                    }
                }
            }
            // for (int j=0;j<n;j++) {
            //     System.out.print(parked[j]);
            // }
            // System.out.println();
        }

        System.out.println(ans);
    }
}
