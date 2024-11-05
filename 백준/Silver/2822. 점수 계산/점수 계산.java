import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] scores = new int[8][2];
        for (int i = 0; i < 8; i++) {
            scores[i][0] = i;
            scores[i][1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(scores, (o1, o2) -> o1[1] - o2[1]);
        int sum = 0;
        int[] result = new int[8];
        for (int i = 3; i < 8; i++) {
            sum += scores[i][1];
            result[i] = scores[i][0] + 1;
        }
        Arrays.sort(result);
        System.out.println(sum);
        for (int i : result) {
            if (i != 0)System.out.print(i + " ");
        }
    }
}
