import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] budget;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        budget = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            budget[i] = sc.nextInt();
            max = Math.max(max, budget[i]);
        }
        sc.close();

        binarySearch(max, Arrays.stream(budget).sum());
        System.out.println(ans);
    }

    static int cnt(int k) {
        int now = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (k < budget[i]) { // 하루 예산도 충족하지 못하면 실패
                return -1;
            }
            if (now < budget[i]) { // 현재 금액으로 충족 불가능하면 인출
                now = k;
                cnt++;
            }
            now -= budget[i];
        }
        return cnt;
    }

    static void binarySearch(int a, int b) {
        int left = a;
        int right = b;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = cnt(mid);
            if (count == -1 || count > m) {
                left = mid+1;
            }
            else {
                ans = Math.min(mid, ans);
                right = mid-1;
            }
        }
    }
}
