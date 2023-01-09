import java.util.Arrays;
import java.util.Scanner;

/*
    알파벳을 숫자로 바꾸기. 중복 x
    높은 자리일수록 높은 수
    높은 자리 알파벳 순으로 정렬

    1. 알파벳 배열에 자리수 저장
    ㄴ ABC라면 alpha[A]에 100, alpha[B]에 10.. 저장
    2. 알파벳 배열 내림차순 정렬
    3. sum += alpha[i--] * 9--
 */
public class q1339 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] alpha = new int[26];
        String[] word = new String[n];

        // 단어 입력
        for (int i = 0; i < n; i++) {
            word[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            int size = word[i].length();
            //System.out.println("size = " + size);
            // 세자리면 100
            int digit = (int) Math.pow(10, size - 1);
            //System.out.println("digit = " + digit);

            for (int j = 0; j < size; j++) {
                // A는 0, B는 1...
                int index = word[i].charAt(j) - 'A';
                //System.out.println("index = " + index);
                //System.out.println("alpha["+ index+"]1 = " + alpha[index]);
                alpha[index] += digit;
                //System.out.println("alpha["+ index+"]2 = " + alpha[index]);
                digit /= 10;
            }
        }

        Arrays.sort(alpha); // 알파벳 배열 값 오름차순 정렬

        int ans = 0;
        int index2 = 9;
        for (int i=alpha.length-1; i>=0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            ans += alpha[i] * index2;
            index2--;
        }

        System.out.println(ans);
    }
}