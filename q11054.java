import java.util.Arrays;
import java.util.Scanner;

/*
    - 가장 긴 증가하는 부분 수열 (lis)
    A[] : 1 2 1 3 2 5
    Dp[]: 1 2 1 3 2 4
    이전값보다 크면 그 값보다 1 증가, 같으면 해당 값으로

    최장 증가 부분 수열 (lis)
    최장 감소 부분 수열 (lds)

    바이토닉 - lis + lds
    증가하는 부분 수열 길이 최대로, 감소하는 부분 수열 길이 최대로
    둘 다 만족해야 함
    https://squareyun.tistory.com/27
*/

public class q11054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dplis = new int[n+1];
        int[] dplds = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // lis
        for (int i = 1; i <= n; i++) {
            dplis[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) { // 이전값이 더 작은 경우
                    dplis[i] = Math.max(dplis[j] + 1, dplis[i]);
                }
            }
        }

        // lds
        for (int i = n; i > 0; i--) {
            dplds[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[j] < arr[i]) { // 이전값이 더 작은 경우
                    dplds[i] = Math.max(dplds[j] + 1, dplds[i]);
                }
            }
        }

        // 두 dp 배열의 합의 최대값 찾기 (dplis[i] + dplds[i]의 최대값)
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dplis[i] + dplds[i]);
        }

        System.out.println(max - 1); // 해당 원소 중복되므로 -1
        sc.close();
    }
}