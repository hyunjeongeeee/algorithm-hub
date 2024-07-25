import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int temp = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < Math.abs(temp)) {
                temp = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if(sum < 0) left++;
            else right--;
        }
        System.out.println(result[0] + " " + result[1]);

    }
}
