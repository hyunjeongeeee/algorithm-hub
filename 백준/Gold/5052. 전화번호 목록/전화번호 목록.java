import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];

            for (int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
            }

            Arrays.sort(phoneNumbers);
            boolean consistent = true;
            for (int j = 0; j < n - 1; j++) {
                if (phoneNumbers[j + 1].startsWith(phoneNumbers[j])) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) System.out.println("YES");
            else System.out.println("NO");    
        }
    }
}