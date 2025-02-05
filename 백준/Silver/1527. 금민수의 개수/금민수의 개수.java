import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 단순 노가다. 브루트포스
 * 어차피 범위가 커봤자 백만이므로, java 정수 범위만 long으로 잘 신경쓰면
 * 1~100만까지, 4와 7로만 이루어진 수들을 만들어서 a, b와 범위비교해 개수 계산하면 끗
 */

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

        // 특정 자리수를 가지는 금민수들을 저장할 리스트
        // ex. {4,7} -> {44, 47, 74, 77} -> {444, 447, 474, 477, 744, 747, 774, 777}
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
    
    // 
    static void solve() {
        int[] arr = {4, 7};
        for (int i=0;i<8;i++) {
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