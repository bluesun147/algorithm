import java.util.Scanner;
// https://yongku.tistory.com/entry/백준-알고리즘-백준-1149번-RGB거리-자바Java
// https://st-lab.tistory.com/128
/*
집이 1번부터 n번까지 있다
집 rbg 중 한 색깔
비용 최소값
1번 != 2번, n번 != n-1번
(i-1번) != (i번) != (i+1번)
즉 인접한 집과는 달라야 함.
색깔별로 비용 다름 -> 최솟값

점화식을 생각해보자
   red                                   grn       blu
----------------------------------------------------------
 c[1][0]                               c[1][1]   c[1][2]
 c[2][0] += min(c[1][1], c[1][2])
 . . .
 c[n][0] += min(c[n-1][2], c[n-2[2]])

 */
public class q1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 집 수
        int[][] dp = new int [n+1][3]; // 0부터 해도 되는데 보기 좋으라고

        for(int i=1; i<=n; i++) {
            int red = sc.nextInt();
            int green = sc.nextInt();
            int blue = sc.nextInt();

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;
        }
        // 맨 마지막 줄에 누적 합 나옴, 셋 중 최솟값.
        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
