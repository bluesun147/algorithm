import java.util.Scanner;
// https://velog.io/@yanghl98/백준-10819-차이를-최대로
/*
정수 배열 순서 바꿔서 연산 최댓값 나오도록
|a[0]-a[1]| + |a[1]-a[2]| ...
n의 최대값이 8이므로 모든 경우의 수 다 구해도 됨.
dfs 사용해 brute force
*/
public class q10819 {
    public static int n, result; // 입력할 배열의 원소수,
    public static int[] arr; // 배열
    public static boolean[] visited; // 방문 체크 배열
    public static int[] selected; // 경우의 수

    // 재귀를 사용한 dfs
    public static void dfs(int count) {
        if (count == n) {
            result = Math.max(getResult(), result);
            return;
        }

        for(int i=0; i<n; i++){
            if (!visited[i]) { // 방문 안했다면
                visited[i] = true; // 방문 처리
                selected[count] = arr[i]; // 
                dfs(count + 1); // 결국 dfs(0)부터 dfs(n)까지 계산
                visited[i] = false;
            }
        }
    }

    public static int getResult() {
        int sum = 0;
        for (int i=0; i<n-1; i++) {
            sum += Math.abs(selected[i] - selected[i+1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        selected = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(result);
    }
}