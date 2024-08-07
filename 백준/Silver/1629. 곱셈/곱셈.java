import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(modularExponentiation(a, b, c));
    }

    static long modularExponentiation(long a, long b, long c) {
        long result = 0;
        if (b == 0) return 1; // b가 0인경우 1 반환
        if (b == 1) return a % c;
        long half = modularExponentiation(a, b / 2, c);
        half = (half * half) % c;

        if (b % 2 != 0) {
            result = (half * a) % c;
        } else {
            result = half;
        }
        return result;
    }
}