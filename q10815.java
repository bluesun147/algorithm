import java.util.Arrays;
import java.util.Scanner;

/*
    숫자 카드 n개
    정수 m개가 주어졌을 때, 카드에 그 수가 포함 되는지
    n배열에 m[i]가 있는지 찾기 -> 이진탐색
 */
public class q10815 {

    static int[] arrN;

    // 이진 탐색
    public static int binSearch(int key, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == arrN[mid]) { // 중앙값이 찾는 값이면
                return 1;
            } else if (key < arrN[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arrN = new int[n];

        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }

        Arrays.sort(arrN); // 오름차순 정렬

        int m = sc.nextInt();
        int[] arrM = new int[m];

        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.print(binSearch(arrM[i], 0, arrN.length-1) + " ");
        }
    }
}