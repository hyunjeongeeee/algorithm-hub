import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long j = Long.parseLong(br.readLine());
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        List<HashMap.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // 빈도수가 가장 높은 카드와 그 빈도수를 저장할 변수
        long maxKey = Long.MAX_VALUE;
        int maxValue = 0;

        for (HashMap.Entry<Long, Integer> entry : list) {
            long key = entry.getKey();
            int value = entry.getValue();
            if (value > maxValue || (value == maxValue && key < maxKey)) {
                maxKey = key;
                maxValue = value;
            }
        }
        System.out.println(maxKey);
    }
}
