import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
1,2,3,4,5,6,7
2,3,4,5,6,7,1
3,4,5,6,7,1,2
4,5,6,7,1,2
...
7,1,2,4,5,6
원형 큐?
원형 큐 -> 인덱스가 크기 벗어나면 처음[0]으로 돌아감,
원형태에서 k번째 사람만 제거하기
일반 큐 사용 -> 앞에서 빼서 뒤에 넣기 반복
 */
public class q11866 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 총 인원
        int k = sc.nextInt(); // k번째 사람 제거

        for (int i=0; i<n; i++) {
            queue.add(i+1);
        }

        System.out.print("<");

        while (queue.size() > 1) {
            // k 이전까지는 앞에서 빼서 큐 맨 뒤로 보냄 -> 원 형태
            for (int i=0; i<k-1; i++) {
                queue.add(queue.poll());
            }

            // k 번째 수는 출력 후 제거
            System.out.print(queue.poll() + ", ");
        }
        System.out.print(queue.poll() + ">");
    }
}