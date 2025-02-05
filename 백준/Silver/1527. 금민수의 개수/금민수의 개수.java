import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int ans;
    static int a;
    static int b;
    static List<Long> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();

        list = new ArrayList<>();
        list.add((long)4);
        list.add((long)7);

        ans = 0;
        if (a <= 4 && b >= 4) {
            ans++;
        }
        if (a <= 7 && b >= 7) {
            ans++;
        }
        solve();
        System.out.println(ans);
    }
    static void solve() {
        int[] arr = {4, 7};
        for (int i=0;i<9;i++) {
            // System.out.println(list);
            List<Long> tempList = new ArrayList<>();
            int size = list.size();
            for (int j=0;j<size;j++) {
                for (int k=0;k<2;k++) {
                    long temp = list.get(j)*10 + arr[k];
                    tempList.add(temp);
                    if (temp >= a && temp <= b) {
                        ans++;
                    }
                }
            }
            list = tempList;
            if (list.isEmpty()) {return;}
        }
    }
}