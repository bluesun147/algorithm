import java.util.Scanner;
/*
2층 3호 -> 1층 1,2,3호 합
1층 3호 -> 0층 1,2,3호 합
k층 n호 몇명 사는지

1 5 15 35
1 4 10 20
1 3 6 10
1 2 3 4
메모이제이션?
 */
public class q2775 {
    static int[][] memo;

    public static int cal(int k, int n) {
        if (k == 0) return memo[0][n] = n;
        if (n == 1) return memo[k][1] = 1;
        if (memo[k][n] != 0) { // 메모되어있다면
            return memo[k][n];
        } else { // 메모되어있지 않다면
            memo[k][n] = cal(k, n - 1) + cal(k - 1, n);
            // System.out.println("memo[" + k + "][" + n + "] = " + memo[k][n]);
            return memo[k][n];
        }
    }

    public static void main(String[] args) {
        memo = new int[15][15];
        Scanner sc = new Scanner(System.in);

        int t, k, n; // 테스트 케이스, 층, 호
        t = sc.nextInt();

        for (int i=0; i<t; i++)
        {
            k = sc.nextInt();
            n = sc.nextInt();
            System.out.println(cal(k, n));
        }
    }
}