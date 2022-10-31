import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
언젠간 반복되기 때문에 계속 반복하면서 중복된 값이 나오면 인덱스 확인
https://steady-coding.tistory.com/32
다른 방법으로도 풀어보기, dfs
*/
public class q2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> visited = new ArrayList<>();
        int num = sc.nextInt();
        int p = sc.nextInt();
        int ans;

        visited.add(num);

        while (true) {
            int cal = visited.get(visited.size()-1); // 맨 뒤 원소
            int result = 0;

            // 제곱
            while (cal != 0) {
                result += Math.pow(cal%10, p);
                cal /= 10;
            }

            // result가 list에 포함되어있다면 인덱스 반환
            if (visited.contains(result)) {
                ans = visited.indexOf(result);
                break;
            }

            visited.add(result);
        }

        System.out.println(ans);
    }
}
