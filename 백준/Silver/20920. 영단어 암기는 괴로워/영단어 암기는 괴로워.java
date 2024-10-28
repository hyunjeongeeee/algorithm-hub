import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int words = Integer.parseInt(st.nextToken());
        int wordLength = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words; i++) {
            String temp = br.readLine();
            if (temp.length() >= wordLength) {
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = map.get(o2).compareTo(map.get(o1));
                if (map.get(o1) == map.get(o2)) {
                    result = o2.length() - o1.length();
                    if (result == 0) {
                        result = o1.compareTo(o2);
                    }
                }
                    return result;
            }
        });

        for (String key : keySet) {
            bw.write(key + "\n");            
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
