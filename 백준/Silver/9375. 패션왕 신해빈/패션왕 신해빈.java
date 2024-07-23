import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수
        StringTokenizer st = null;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());    // 해빈이가 가진 의상 수
            HashMap<String, Integer> map = new HashMap<>();
            int result = 1; // 결과 담을 변수

            for(int i=0; i<n; i++) { // 의상 이름, 종류 공백으로 구분
                st = new StringTokenizer(br.readLine());
                st.nextToken();  // 의상 이름
                String cType = st.nextToken();  // 의상 타입

                if (map.containsKey(cType)) {
                    map.put(cType,map.get(cType)+1);   //  같은 종류의 의상이 나올때마다 count+1
                } else {
                    map.put(cType, 1);  // 중복이 없는경우 1 삽입
                }
           }
            for (int val : map.values()) {
                result *= (val + 1);
            }
            System.out.println(result-1);
        } // end of while
    }
}
