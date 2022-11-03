public class dynamic_programming {
    // 피보나치 구하는 두가지 방법
    // 1. 재귀
    static long fibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

    // 2. 메모이제이션
    // 한번 구한 계산은 더 이상 계산 x, 가져다 쓰는 개념
    static long[] arr = new long[51]; // 저장해 둘 배열 선언
    // Top Down 방식
    // 재귀는 Top Down 방식
    static long fiboM(int n) {
        if (n == 0) {
            return arr[0];
        } else if (n == 1) {
            arr[1] = 1;
            return arr[1];
        } else if (arr[n] != 0) { // 한번 이상 구한 것은 바로 저장되어 있는 값 리턴
            return arr[n];
        } else { // 계산한 적 없는 경우
            return arr[n] = fiboM(n-1) + fibo(n-2);
        }
    }

    // Bottom Up 방식
    // 가장 작은 문제들부터 답 구해가며 전체 문제 답 찾는 방식
    // 재귀 호출 하지 않기떄문에 시간과 메모리 줄임
    // dp의 전형적인 형태는 Bottom Up
    static long fiboB(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

   public static void main(String[] args) {
        int n = 10;
        System.out.println(fiboM(n));
    }
}
