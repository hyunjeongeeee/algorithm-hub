import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();
                if (result == 0) {
                    if (stringToInt(o1) - stringToInt(o2) == 0) {
                        result = o1.compareTo(o2);
                    } else {
                        result = stringToInt(o1) - stringToInt(o2);
                    }
                }
                return result;
            }
        });
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            pq.add(str);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static int stringToInt(String str) {
        int result = 0;
        int temp = str.length();
        for (int i = 0; i < temp; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result += str.charAt(i) - '0';
            }
        }
        return result;
    }
}
