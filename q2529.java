import java.util.*;
// https://pangtrue.tistory.com/283
/*
두 종류 부등호로 이뤄진 배열 <<><><
배열 원소수+1 개의 수 다 합친것 -> 부등호 관계 만족시키는 정수
0,1,2,,9로 이뤄져야 함. 모두 달라야 함.
그 정수의 max와 min

dfs 백트래킹을 사용하여 완전탐색을 해서 해결
dfs 탐색의 깊이가 부등호 개수+1 만족하면 조건 만족하는 수열

백트래킹: 해 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해 찾는 기법
dfs를 하는 와중 더 이상 탐색할 필요가 없는 걸 쳐내는 행위를 백트래킹이라고 함.
 */
public class q2529 {
    
    static int k; // 부등호 개수
    static char[] signs; // 부등호 배열
    static boolean[] visited = new boolean[10]; // 0부터 9까지 한번씩만 쓰야야 함
    static List<String> ans = new ArrayList<>(); // 답 (정수를 문자열로)

    public static void dfs(String num, int idx) { // 인자로 숫자와, dfs 인덱스 (깊이)
        // dfs 탐색의 깊이가 부등호 개수+1 만족하면 조건 만족하는 수열. 반환
        if (idx == k+1) {
            ans.add(num); // 만족하면
            return;
        }

        for (int i=0; i<=9; i++) {
            if (visited[i]) continue; // if (!visited[i]) 하면 계속 체크해야 하므로?
            if (idx == 0 || check(Character.getNumericValue(num.charAt(idx-1)), signs[idx-1], i)) {
                visited[i] = true; // 방문 표시
                dfs(num+i, idx+1);
                visited[i] = false; // 끝나고는 다시 false로
            }
        }
    }

    // 부등호 식이 맞는지 체크
    public static boolean check(int a, char c, int b) {
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        dfs("", 0);

        Collections.sort(ans); // ans 오름차순 정렬
        System.out.println(ans.get(ans.size()-1)); // 최대값
        System.out.println(ans.get(0)); // 최소값
    }
}
