import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arrayList.add(str);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (arrayList.contains(str)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
