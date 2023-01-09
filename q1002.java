import java.util.*;

/*
직원 a, b가 c의 위치 구해야 함.
r1: a와 c 사이 거리
r2: b와 c 사이 거리
r3: a와 b 사이 거리
r1, r2 이용해서 c의 위치의 수
나올 수 있는 수 - 0,1,2,무한(둘 위치 같을 경우)
ㄴ 두 점 찍고 원 그렸을 때
 */
public class q1002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            // a,b 사이 거리
            double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

            if (x1 == x2 && y1 == y2 && r1 == r2) // 두 원 같을 때
                System.out.println(-1);
            else if ((d == r1 + r2) || (d == Math.abs(r1 - r2))) // 외접 or 내접
                System.out.println(1);
            else if ((Math.abs(r1 - r2) < d) && (d < r1 + r2)) // 서로 다른 두 점
                System.out.println(2);
            else
                System.out.println(0);
        }
    }
}