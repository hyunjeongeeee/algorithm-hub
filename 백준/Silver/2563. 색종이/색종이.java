import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] square = new boolean[100][100]; // 100 * 100 크기의 도화지
        int area = 0;
        for (int i = 0; i < N; i++) { // 영역을 true로 바꿔주기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    if(!square[j][k]) {
                        square[j][k] = true;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
