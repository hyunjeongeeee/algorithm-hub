import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int num1 = y / 100; // 100의자리수
        int num2 = (y / 10) - (num1 *10); // 10의자리수
        int num3 = y - (num1 * 100) - (num2 * 10); // 1의자리수

        System.out.println(x * num3);
        System.out.println(x * num2);
        System.out.println(x * num1);
        System.out.println(x * y);
    }
}
