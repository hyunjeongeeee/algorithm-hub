import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
           for (int j = n; j >= 1; j--) {
               if(i >= j) sb.append("*");
               else sb.append(' ');
           }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
