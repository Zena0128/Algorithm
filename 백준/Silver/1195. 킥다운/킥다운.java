import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(String.join(" ", br.readLine().split("")), " ");

        while (st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(String.join(" ", br.readLine().split("")), " ");
        while (st.hasMoreTokens()) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        if (a.size() > b.size()) {
            List<Integer> temp = new ArrayList<>();
            temp = a;
            a = b;
            b = temp;
        }
        for (int i=0;i<a.size();i++) {
            b.add(0, 0);
            b.add(0);
        }

        int ans = b.size() - a.size();

        for (int i=0;i<b.size()-a.size();i++) {
            if (isAvailable(i)) {
                int temp;
                if (i < b.size()-2*a.size()) {
                    temp = b.size()-a.size()-i;
                }
                else {
                    temp = i;
                }
                ans = Math.min(ans, Math.max(temp, b.size()-2*a.size()));
            }
        }

        System.out.println(ans);





        // int ans1 = a.size();
        // int ans2 = b.size();
        
        // for (int i=0;i<a.size();i++) {
        //     boolean available1 = true;
        //     for (int j=i;j<Math.min(b.size(), a.size()-i);j++) {
        //         // System.out.println(j + " " + (j-i));
        //         // System.out.println(a.get(j));
        //         // System.out.println(b.get(j-i));
        //         if (a.get(j) + b.get(j-i) == 4) {
        //             // System.out.println("false!");
        //             available1 = false;
        //             break;
        //         }
        //     }
        //     if (available1) {
        //         System.out.println(i);
        //         if (i < a.size()-1) {
        //             ans1 = i;
        //             break;
        //         }
        //     }
        // }
        // // System.out.println(ans1);


        // for (int i=0;i<b.size();i++) {
        //     boolean available2 = true;
        //     for (int j=i;j<Math.min(a.size(), b.size()-i);j++) {
        //         // System.out.println(j + " " + (j-i));
        //         if (b.get(j) + a.get(j-i) == 4) {
        //             available2 = false;
        //             break;
        //         }
        //     }
        //     if (available2) {
        //         if (i < b.size()-1) {
        //             ans2 = i;
        //             break;
        //         }
        //     }
        // }
        // // System.out.println(ans2);

        // System.out.println(Math.max(Math.min(ans1+b.size(), ans2+a.size()), Math.max(a.size(), b.size())));


        // int idx1 = 0;
        // int idx2 = 0;
        // int x = 0;
        // int y = 0;
        // for (int i=0;i<a.size();i++) {
        //     if (x == b.size()) {break;}
        //     if (a.get(i)+b.get(x) == 4) {
        //         idx1 = i;
        //         x = 0;
        //     } else {
        //         x++;
        //     }
        //     if (i == a.size()-1 && x == 0) {
        //         idx1++;
        //     }
        //     System.out.println(idx1+" "+x);
        // }

        // while () {
        //     if (y == a.size()) {break;}
        //     if (b.get(i)+a.get(y) == 4) {
        //         idx2 = i;
        //         y = 0;
        //     } else {
        //         y++;
        //     }
        //     if (i == b.size()-1 && y == 0) {
        //         idx2++;
        //     }
        //     System.out.println(idx2+" "+y);
        // }
        // int ans = Math.min(idx1+b.size(), idx2+a.size());
        // System.out.println(Math.max(ans, Math.max(a.size(), b.size())));

    }

    static boolean isAvailable(int i) {
        for (int j=i;j<a.size()+i;j++) {
            if (b.get(j)+a.get(j-i) == 4) {
                return false;
            }
        }
        return true;
    }
}
