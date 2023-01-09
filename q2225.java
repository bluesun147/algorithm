import java.util.Scanner;

/*
0부터 10까지의 정수 3개를 더해서 10이 되는 경우의 수

n을 k개로 쪼개야 한다.

10 =
0+10 -> 0(하나) + 10을 2개로 쪼개기
1+9
2+8
...
9+1
10+0

12를 4개로 쪼개야 한다면
0 + 12 -> 0 + 12를 3개로 쪼개기 -> 0 + 0 + 12를 2개로 쪼개기 (0+0+d[12][2] == 0+0+13) -> 0 + 0 + 0 + 12, 0 + 0 + 1 + 11 ..

-> 동적 프로그래밍 ?
k <= n+1
d[n][k] = d[0][k-1] + d[1][k-1] ... + d[n][k-1]
3,2 -> 0,2 1,2 2,2
d[1][0]
  0 1 2 3 4 5 6 7
0 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1
2 1 2 3 4 5 6 7 8
3 1,3,6,10,15,21,28
4 1,4,10,20,35,56,84
5 1
6 1
7 1
d[n][k] = d[n][k-1] + d[n-1][k]
 */
public class q2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] d = new int[201][201];

        for (int i = 0; i < 201; i++) {
            d[0][i] = 1;
            d[i][0] = 1;
            d[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = (d[i][j - 1] + d[i - 1][j])%1000000000;;
            }
        }

        System.out.println(d[n][k]);
    }
}