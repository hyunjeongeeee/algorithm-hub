import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    private static boolean visited[];
    private static int arr[];
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int N, int M, int depth) {

        //  N = 4 , M = 2 라 가정
        // 재귀 탈출 조건
        // 재귀 깊이가 M 과 같아지면 탐색 과정에서 담았던 배열을 출력
        if(depth==M) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            // 해당 노드를 방문하지 않았다면?
            if(!visited[i]){
                visited[i] = true;  // 해당 노드를 방문 상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i+1 값 저장
                dfs(N,M,depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출

                // 자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경
                visited[i] = false;
            }
        }



    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력받은 첫번째 숫자  (1~ N까지)
        int M = Integer.parseInt(st.nextToken()); // 입력받은 두번째 숫자  ( => M개)

        visited = new boolean[N]; // 방문 조건 저장
        arr = new int[M]; //

        dfs(N,M,0); // 재귀함수 호출

        System.out.println(sb);

    }
}
