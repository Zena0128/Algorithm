import java.util.Scanner;

public class Main {

    static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        sc.close();

        if (b == 1) {System.out.println(a % c);}
        else {System.out.println(dc(b));}

    }

    static long dc(int i) {
        if (i == 1) {
            return a % c;
        } else {
            long temp = dc(i/2);
            long pow = temp * temp % c;
            
            if (i % 2 == 1) {
                return pow * a % c;
            }
            return pow;
        }
    }
}
