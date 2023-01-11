import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
    최소 힙 (자료구조) - 가장 작은 값이 루트
    완전 이진 트리, 자식이 부모보다 커야 함. 왼쪽, 오른쪽 x
    배열 형태로 구현

    자식 인덱스 구하기 (1부터 시작)
    left = parent * 2
    right = parent * 2 + 1

    삽입


    기능
     - n : 배열에 자연수 x 넣기
     - 0 : 가장 작은 값 출력 후 제거


 */
public class q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pq.add(num);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else { // 배열 빈 경우
                    System.out.println(0);
                }
            }
        }
    }
}