import java.util.Scanner;

/*
    이친수 - 이진수인데 1로 시작, 1 두번 연속 나타나지 x
    즉
    n자리 이친수의 개수 구하기
    ex) 3일때 - 101, 100
    이전 자리가 1이면 다음에 1 나오면 안됨.
    dp 이용한다면
    1의 자리 - 1
    2의 자리 - 10
    3의 자리 - 101, 100
    4의 자리 - 1010, 1000, 1001
    5의 자리 - 10100, 10101, 10000, 10001, 10010

    -> 즉 전 자리 이친수 뒤에 0 또는 1 붙이면 다음 자리 이친수 나옴.
    n자리 이친수 개수 = (1) + (2)
    (1) n-1 자리 0으로 끝나는 이친수 * 2
    (2) n-1 자리 1로 끝나는 이친수 * 1
    https://chanhuiseok.github.io/posts/baek-6/
 */
public class q2193 {

    public static int pin(int num) {

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[91][2];

        dp[1][0] = 0; // 1자리 일 때 0으로 끝나는
        dp[1][1] = 1; // 1자리 일 때 1으로 끝나는

        for (int i = 2; i <= n; i++) {
            if (dp[i - 1][0] >= 1) {
                dp[i][0] += dp[i - 1][0];
                dp[i][1] += dp[i - 1][0];
            }
            if (dp[i - 1][1] >= 1) {
                dp[i][0] += dp[i - 1][1];
            }
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}