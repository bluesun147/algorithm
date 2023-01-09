import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    다른 어떤 지원자의 성적에 비해 적어도 하나가 성적 떨어지지 않는다면 선발됨
    https://zzang9ha.tistory.com/51
    https://minhamina.tistory.com/118
 */
public class q1946 {
    public static void main(String[] args) throws IOException {
        // scanner로 하면 시간초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int count = 1; // 서류 1순위는 무조건 선발이기 때문
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 서류
                arr[i][1] = Integer.parseInt(st.nextToken()); // 면접
            }

            // 서류 등수 높은순으로 정렬
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int min = arr[0][1];
            for (int i = 1; i < N; i++) {
                if (arr[i][1] < min) {
                    count++;
                    min = arr[i][1];
                }
            }

            System.out.println(count);
        }
    }
}