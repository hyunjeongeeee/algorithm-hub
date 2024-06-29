import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long index = n % 1500000;
        long[] fb = new long[(int)index + 1];

        if(n==0) {
            System.out.println("0");
            return;
        } else {
            fb[0] = 0;
            fb[1] = 1;

            for (int i = 2; i <= index; i++) {
                fb[i] = (fb[i - 1] + fb[i - 2]) % 1000000;
            }
            System.out.println(fb[(int)index]);
        }

    }
}
