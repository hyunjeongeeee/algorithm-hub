import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case 'A','B','C': result += 3; break;
                case 'D','E','F': result += 4; break;
                case 'G','H','I': result += 5; break;
                case 'J','K','L': result += 6; break;
                case 'M','N','O': result += 7; break;
                case 'P','Q','R','S': result += 8; break;
                case 'T','U','V': result += 9; break;
                case 'W','X','Y','Z': result += 10; break;
            }
        }
        System.out.println(result);
    }
}
