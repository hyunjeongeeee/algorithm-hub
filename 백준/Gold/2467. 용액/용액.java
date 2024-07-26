import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < Math.abs(min)) {
                min = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if(sum < 0) left++;
            else right--;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
