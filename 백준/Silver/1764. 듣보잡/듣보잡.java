import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> oldMap = new HashMap<>();   // 듣
        HashMap<String,Integer> newMap = new HashMap<>();   // 보
        TreeMap<String, Integer> result = new TreeMap<>();  // 결과담을 맵

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        for(int i=0; i< num1; i++) {
            oldMap.put(br.readLine(), 0);
        }

        for(int i=0; i< num2; i++) {
            newMap.put(br.readLine(), 0);
        }


        // oldMap을 순회하며 중복된 키 = oldMap의 value를 +1 해줌
        for (Map.Entry<String, Integer> entry : oldMap.entrySet()) {
            String key = entry.getKey();    //  oldMap 키
            if(newMap.containsKey(key)) {   // newMap에 oldMap과 같은Key가 있을경우
                result.put(key, oldMap.get(key)+1); // result에 (key, value+1) 담기
            }
        }


        // 출력해야할 내용
        sb.append(result.size()).append("\n"); // 중복 인원수

        Iterator<String> re = result.keySet( ).iterator( );
        while(re.hasNext()) {
            sb.append(re.next()).append("\n");
        }

        System.out.println(sb);

    }

}
