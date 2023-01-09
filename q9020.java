import java.util.Scanner;

/*
두 소수 차이가 가장 작아야 함.
ex) n이 14일때
가장 작으려면 7,7 (n/2, n/2)
가장 큰 경우 1,13 (1, n-1)
두 소수 (a, b)가 (n/2, n/2) 일때부터 (1, n-1)가 될때까지
a--, b++ 하면서 a,b가 둘다 소수일 경우 return.

 */
public class q9020 {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int a = n / 2, b = n / 2;

            while (true) {
                if (isPrime(a) && isPrime(b)) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }
        }
    }
}