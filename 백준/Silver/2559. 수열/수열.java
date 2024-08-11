import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜 수
        int K = Integer.parseInt(st.nextToken()); // 연속적인 날짜의 수
        int[] temperature = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) { 
            sum += temperature[i];
        }
        int temp = sum;

        for (int i = K; i < N; i++) {
            temp = temp - temperature[i - K] + temperature[i];
            sum = Math.max(sum, temp);
        }

        System.out.println(sum);
    }
}
