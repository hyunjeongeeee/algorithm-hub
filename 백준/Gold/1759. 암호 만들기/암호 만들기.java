import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static boolean[] visited;
    static String[] password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[C];
        password = new String[C];
        password = br.readLine().split(" ");
        Arrays.sort(password);
        backtracking(0, "");
    }

    private static void backtracking(int start,  String pw) {
        if (pw.length() == L) {
            if (checkPassword(pw)) {  // 조건을 만족하는 암호일 때만 출력
                System.out.println(pw);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            backtracking(i + 1, pw + password[i]);
        }

    }

    // 비밀번호의 조건 확인하기 -> 최소 한개의 모음 + 최소 두개의 자음으로 구성
    private static boolean checkPassword(String password) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == 'a' || password.charAt(i) == 'e'
                    || password.charAt(i) == 'i' || password.charAt(i) == 'o'
                    || password.charAt(i) == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}
