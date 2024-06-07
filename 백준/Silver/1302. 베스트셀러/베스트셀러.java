import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        
        while (N-- > 0) {   // 입력받기
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        ArrayList<String> arrayList =new ArrayList<>();
        int maxValue = Collections.max(map.values());
        for(Map.Entry<String, Integer> m : map.entrySet()) {    // 최대값 찾아서 arrayList에 넣기
            if(m.getValue()==maxValue) {
                arrayList.add(m.getKey());
            }
        }
        Collections.sort(arrayList); // 오름차순으로 정렬
        System.out.println(arrayList.get(0));
    }
}
