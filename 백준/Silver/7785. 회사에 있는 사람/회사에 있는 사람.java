import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());  // 사원정보를 담을 트리맵 선언
        int n = Integer.parseInt(br.readLine());   // 출입 기록의 수
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();   // 사원명
            String record = st.nextToken(); // 출입기록

            switch (record) {
                case "enter":
                    map.put(name, record);
                    break;
                case "leave":
                    map.remove(name);
                    break;
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
