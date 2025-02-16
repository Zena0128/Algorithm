import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n *= n];
        long sum = 1;
        while (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                sum += arr[--n] = Integer.parseInt(st.nextToken());
        }

        sum /= 2;
        int low = 0, high = 10000000;
        while (low <= high) {
            int mid = (low + high) / 2;

            long cnt = 0;
            for (int i : arr)
                cnt += Math.min(i, mid);

            if (cnt < sum) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(low);
    }

}