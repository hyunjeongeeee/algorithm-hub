import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }

        // 최대 길이 구하기
        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i].length > maxLen) {
                maxLen = arr[i].length;
            }
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length) {
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}