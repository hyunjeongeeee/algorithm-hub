import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(palindrome(s));

    }
    static int palindrome(String s) {
        int length = s.length();
        int answer = 0;
        for(int i = 0; i < length / 2; i++) {
            if(s.charAt(i) != s.charAt(length - 1 - i)) {
                answer = 0;
                break;
            } 
            else answer = 1;
        }
        if(length == 1) answer = 1; // 길이가 1인경우
        return answer;
    }
}
