import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static List<Integer>[] network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int connectionsCount = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        network = new ArrayList[computerCount + 1];
        for (int i = 0; i <= computerCount; i++) {
            network[i] = new ArrayList<>();
        }

        // 네트워크 연결 정보 입력
        StringTokenizer st;
        for (int i = 0; i < connectionsCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            network[x].add(y);
            network[y].add(x); // 양방향 연결
        }

        visited = new boolean[computerCount + 1];
        int infectedCount = dfs(1); // 1번 컴퓨터에서 시작

        // 1번 컴퓨터를 제외한 감염된 컴퓨터 수 출력
        System.out.println(infectedCount - 1);
    }

    static int dfs(int computer) {
        visited[computer] = true;
        int count = 1; // 현재 컴퓨터를 포함

        for (int neighbor : network[computer]) {
            if (!visited[neighbor]) {
                count += dfs(neighbor); // 연결된 컴퓨터 탐색
            }
        }
        return count;
    }
}
