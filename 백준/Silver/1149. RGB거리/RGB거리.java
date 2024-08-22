import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         StringTokenizer st = null;
        int[][] arr = new int[N][3];
        // 만약, N번 집의 색이 빨간색이라면, N + 1의 집의 색깔은 초록색이나 파란색으로 칠하는 경우밖에 존재하지 않는다.
        // 다시 말하면 N번 집의 색이 빨간색이라면 N - 1의 집의 색은 초록색이나 파란색이라는 의미가 된다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i < N; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
        }

        System.out.println(Math.min(arr[N - 1][0], Math.min(arr[N - 1][1], arr[N - 1][2])));

    }
}
