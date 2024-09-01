import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 국가의 수
            int m = Integer.parseInt(st.nextToken()); // 비행기의 종류
            // 최소 비행기 수는 국가 수 - 1
            System.out.println(n - 1);

            // 입력을 무시하기 위해 m개의 줄을 읽음
            for (int i = 0; i < m; i++) {
                br.readLine();
            }
        }
    }
}
