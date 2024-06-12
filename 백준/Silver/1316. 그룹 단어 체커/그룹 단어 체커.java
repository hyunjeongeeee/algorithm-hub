import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N-- > 0) {
            String world = br.readLine();
            if(isGroupWorld(world)) count++;       
        }
        System.out.println(count);
    }
    public static boolean isGroupWorld(String world) {
        boolean[] arr = new boolean[26];    // a-z 등장 여부 기록하는 배열
        char prev = ' ';
        for (int i = 0; i < world.length(); i++) {
            char currentChar = world.charAt(i);
            int index = currentChar - 'a'; // 문자의 인덱스 계산

            if (currentChar != prev) {
                if (arr[index]) { // 이미 등장한 문자라면
                    return false;
                }
                arr[index] = true; // 문자를 등장했다고 표시
                prev = currentChar;
            }
        }
        return true;
    }
}