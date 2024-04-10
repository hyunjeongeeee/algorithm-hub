import java.io.*;

public class Main {
    // N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력

    public static int n, m;
    public static int[] arr; // 원소를 저장할 배열
    public static boolean[] visited; // 중복을 제거하기 위한 방문 처리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
            m = N;
            arr = new int[N];
            visited = new boolean[N + 1];
            permutation(N, 0);
    }
    
    public static void permutation(int N, int cnt) {
        // 재귀 중단
        if (cnt == m) {
            printArr(arr);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {      // 방문 X 일 경우
                visited[i] = true;  // 방문 O 체크
                arr[cnt] = i;
                permutation(N ,cnt + 1);   // 재귀함수
                visited[i] = false; // 방문여부 초기화
            }
        }
    }

    public static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
