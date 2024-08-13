import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] count= new int[K + 3][2];
        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;
        count[2][0] = 1;
        count[2][1] = 1;
        for (int i = 2; i <= K; i++) {
            count[i][0] = count[i - 1][0] + count[i - 2][0];    // A갯수
            count[i][1] = count[i - 1][1] + count[i - 2][1];    // B갯수
        }
        System.out.println(count[K][0] + " " + count[K][1]);
    }
}
