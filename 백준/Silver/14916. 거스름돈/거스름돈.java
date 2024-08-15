import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int LNF = Integer.MAX_VALUE;
        int[] arr = new int[n + 1 + 6];
        arr[0] = LNF;
        arr[1] = LNF;
        arr[2] = 1;
        arr[3] = LNF;
        arr[4] = 2;
        arr[5] = 1;

        for (int i = 6; i < arr.length; i++) {
            arr[i] = Math.min(arr[i - 2], arr[i - 5]) + 1;
        }
        System.out.println(arr[n] == LNF ? -1 : arr[n]);
        br.close();
    }
}
