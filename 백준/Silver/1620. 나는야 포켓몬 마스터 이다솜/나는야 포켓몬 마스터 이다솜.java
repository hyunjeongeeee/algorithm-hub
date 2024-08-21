import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 두 개의 맵을 사용
        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();

        // 입력 받아서 두 개의 map에 저장
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }

        // 입력된 값을 처리
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (isNumeric(str)) {
                int num = Integer.parseInt(str);
                System.out.println(numToName.get(num));
            } else {
                System.out.println(nameToNum.get(str));
            }
        }
    }

    // 숫자 여부를 판별하는 메소드
    static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}