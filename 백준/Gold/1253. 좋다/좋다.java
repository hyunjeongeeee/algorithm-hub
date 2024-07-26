import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Arrays.sort(arr);  
        int count = 0;

        for(int k = 0; k < N; k++) {

            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == k) {
                    left++;
                    continue;
                }
                if (right == k) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if (sum > arr[k]) right--;
                else if (sum < arr[k]) left++;
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}