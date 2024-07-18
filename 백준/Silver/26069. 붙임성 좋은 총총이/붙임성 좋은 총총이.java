import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");

        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String dancer1 = st.nextToken();
            String dancer2 = st.nextToken();

            if(set.contains(dancer1) || set.contains(dancer2)) {
                set.add(dancer1);
                set.add(dancer2);
            }
        }
        System.out.println(set.size());
    }
}
