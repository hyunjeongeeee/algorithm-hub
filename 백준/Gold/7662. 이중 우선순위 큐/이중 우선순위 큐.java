import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                switch (str) {
                    case "I":
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        break;
                    case "D":
                        if (map.isEmpty()) break;
                        if (n == -1) {
                            int minKey = map.firstKey();
                            if (map.get(minKey) == 1) map.remove(minKey);
                            else map.put(minKey, map.get(minKey) - 1);
                        } else {
                            int maxKey = map.lastKey();
                            if (map.get(maxKey) == 1) map.remove(maxKey);
                            else map.put(maxKey, map.get(maxKey) - 1);
                        }

                        break;
                }
            }
            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            }else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb);
    }
}
