import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();           // 문자열
        String explosion = br.readLine();      // 폭발문자열
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            result.append(c);

            if (result.length() >= explosion.length()) {
                boolean match = true;
                for (int i = 0; i < explosion.length(); i++) {
                    if (result.charAt(result.length() - explosion.length() + i) != explosion.charAt(i)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    result.delete(result.length() - explosion.length(), result.length());
                }
            }
        }

        if (result.length() == 0) {
            bw.write("FRULA");
        } else {
            bw.write(result.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
