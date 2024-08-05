import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sum = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(recursiveSum(n));
    }

    static int recursiveSum(int n) {
        if (n == 0 || n == 1) return sum;
        sum *= n;
        return recursiveSum(n - 1);
    }
}
