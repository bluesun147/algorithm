import java.util.Scanner;

public class q3085 {
    static int max = 1, n;
    static char board[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
            max = Math.max(max, rowCount(i)); // 행 max 카운트
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, colCount(i)); // 열 max 카운트
        }

        // 모두 바꾸면서 카운트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) { // 행에 대해서
                    swap(i, j, i, j + 1); // 오른쪽과 swap
                    max = Math.max(max, rowCount(i));
                    max = Math.max(max, colCount(j));
                    max = Math.max(max, colCount(j + 1)); // 행에 대해 swap 하면 열에 대해서 두번 체크 해야 함.
                    swap(i, j, i, j + 1); // 원상태로
                }
                if (i + 1 < n) { // 열에 대해서
                    swap(i, j, i + 1, j); // 아래와 swap
                    max = Math.max(max, rowCount(i));
                    max = Math.max(max, rowCount(i + 1));
                    max = Math.max(max, colCount(j));
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    public static int rowCount(int x) { // x 행에서 가장 긴 연속되는 문자 수
        int count = 1, res = 1;
        char ch = board[x][0];
        for (int i = 1; i < n; i++) {
            if (board[x][i] != ch) {
                ch = board[x][i];
                res = Math.max(res, count);
                count = 1;
            } else count++;
        }
        return Math.max(res, count);
    }

    public static int colCount(int y) { // y 열에서 가장 긴 연속되는 문자 수
        int count = 1, res = 1;
        char ch = board[0][y];
        for (int i = 1; i < n; i++) {
            if (board[i][y] != ch) {
                ch = board[i][y];
                res = Math.max(res, count);
                count = 1;
            } else count++;
        }
        return Math.max(res, count);
    }
}