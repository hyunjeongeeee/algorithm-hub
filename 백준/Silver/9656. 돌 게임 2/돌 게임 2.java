import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 4 == 0 || N % 4 == 2) {
            System.out.println("SK");
        } else if (N % 4 == 1 || N % 4 == 3) {
            System.out.println("CY");
        }
    }
}
