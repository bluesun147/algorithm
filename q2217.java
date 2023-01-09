import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    로프 n개
    중량 w인 물체 -> 각 로프에 w/k 씩 배분
    로프 이용해 들 수 있는 최대 중량
    10 40 50 -> 80
    50 40 10
    가장 작은 값 * n ?
    먼저 정렬 -> 큰값부터 고려
    https://hongjw1938.tistory.com/172
 */
public class q2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[n];
        int[] weight = new int[n];

        for (int i=0; i<n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder()); // 배열 내림차순 정렬

        for (int i=0; i<n; i++) {
            weight[i] = (i+1) * rope[i];
        }

        Arrays.sort(weight);
        System.out.println(weight[n-1]);
    }
}