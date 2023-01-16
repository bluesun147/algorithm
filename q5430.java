
//public class q5430 {
//
//    public static void xx(String func, List<String> list) {
//        for (int i = 0; i < func.length(); i++) {
//            if (func.charAt(i) == 'R') {
//                Collections.reverse(list);
//            } else {
//                if (list.isEmpty()) {
//                    System.out.println("error");
//                    return;
//                } else {
//                    list.remove(0);
//                }
//            }
//        }
//
//        Object[] resArr = list.toArray();
//        System.out.println(Arrays.toString(resArr));
//    }
//
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//
//            String func = sc.next();
//
//            int num = sc.nextInt();
//            String[] arr = new String[num];
//            String arrString = sc.next();
//            arrString = arrString.substring(1, arrString.length() - 1);
//            arr = arrString.split(",");
//
//            List<String> list = new ArrayList<>(List.of(arr));
//
//            xx(func, list);
//        }
//    }
//}

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
/*
    실제 배열 뒤집으면 시간초과 (Collections.reverse())
    deque 사용해서 실제 뒤집지 말고 거꾸로 출력 / 뒤에서 하나 제거
 */
public class q5430 {

    public static String ac(String func, Deque<Integer> dq) {
        boolean reverse = false; // 뒤집기 변수
        for (int i = 0; i < func.length(); i++) {
            if (func.charAt(i) == 'R') {
                reverse = !reverse;
            } else {
                if (dq.isEmpty()) {
                    return "error";
                }
                if (reverse) { // 뒤집힌 상황이면 뒤에서 하나 출력
                    dq.removeLast();
                } else {
                    dq.removeFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!dq.isEmpty()) { // dq가 빌때까지
            // reverse가 T면 뒤에서부터 하나씩 출력
            sb.append(reverse ? dq.removeLast() : dq.removeFirst());
            if (dq.size() != 0) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            String func = sc.next();

            int num = sc.nextInt();
            String arrString = sc.next();

            Deque<Integer> dq = new LinkedList<>();

            for (String s : arrString.substring(1, arrString.length() - 1).split(","))
                if (!s.equals(""))
                    dq.add(Integer.valueOf(s));

            System.out.println(ac(func, dq));
        }
    }
}