// 보통 재귀 사용해 dfs 구현
// https://codingnojam.tistory.com/44
public class dfs {
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    static void dfs(int nodeIdx) {
        // 방문 처리
        visited[nodeIdx] = true;

        // 방문 노드 출력
        System.out.print(nodeIdx + " -> ");

        // 방문한 노드의 인접 노드 찾기
        for (int node : graph[nodeIdx]) {
            // 인접한 노드 방문한 적 없다면 dfs 수행 (방문)
            if (!visited[node]) {
                dfs(node);
            }
            // 방문한적 있다면
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }
}
