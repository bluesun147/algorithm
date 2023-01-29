import java.util.Arrays;
import java.util.Scanner;

/*
    가장 긴 증가하는 부분 수열 (lis)
    A[] : 1 2 1 3 2 5
    Dp[]: 1 2 1 3 2 4
    이전값보다 크면 그 값보다 1 증가, 같으면 해당 값으로
    https://developer-mac.tistory.com/71
    https://st-lab.tistory.com/137
 */
public class q11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        dp[0] = 1; // 첫 원소는 1로

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j]) { // 이전값이 더 작은 경우
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}