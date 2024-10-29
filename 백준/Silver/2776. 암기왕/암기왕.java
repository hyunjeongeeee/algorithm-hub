import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<Integer> note1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            note1 = new HashSet<>(n);  
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }
            
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int number = Integer.parseInt(st.nextToken());
                if (note1.contains(number)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        
        System.out.print(sb.toString());
    }
}