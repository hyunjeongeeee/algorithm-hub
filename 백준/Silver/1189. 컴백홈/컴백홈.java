import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // #1) 문제 요약
    // 문제는 R x C 맵에 못가는 부분이 주어지고 거리 K가 주어지면
    // 한수가 집까지도 도착하는 경우 중 거리가 K인 가짓수를 구하는 것
    //  T로 표시된 부분은 가지 못하는 부분
    // 한수는 현재 왼쪽 아래점에 위치 -> 집은 오른쪽 위
    // #2) 접근
    // DFS 활용 -> T: 못가는길 visited배열로 방문 여부 확인
    //    출발 : (R-1, 0) => 도착 (0, C-1)
    //              (출발지 ~ 도착지 이동횟수 == K)인 경로의 수
    static int r, c, k;
    static char[][] arr;
    static int[][] visited; // 방문여부 int형 배열로 확인하기
    static int[] moveR = {1, -1, 0, 0};
    static int[] moveC = {0, 0, 1, -1};
    static int count = 0;

    public static void dfs(int R, int C, int moved) {


        // 도착
        if (R == 0 && C == c-1) {
            if( k == moved) {
                count++;
                return;
            }
        }

        for(int i=0; i<4; i++) {
            int nextR = R + moveR[i];
            int nextC = C + moveC[i];
            if(nextR<0 || nextR>=r || nextC<0 || nextC >= c)   continue;
            if(visited[nextR][nextC] == 1 || arr[nextR][nextC] == 'T')  continue;
            visited[nextR][nextC] = 1;  // 방문시 1 (true)
            dfs(nextR, nextC, moved+1);
            visited[nextR][nextC] = 0; //  초기화 작업 0 (false)

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());   // 행
        c = Integer.parseInt(st.nextToken());   // 열
        k = Integer.parseInt(st.nextToken());   // 거리 (목표지점)

        arr = new char[r][c];
        visited = new int[r][c];
        for(int i=0; i<r; i++) {
            String temp = br.readLine();

            for(int j=0; j<c; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        visited[r-1][0] = 1;    // 초기 위치 1로 잡아주기
        dfs(r-1, 0, 1);
        System.out.println(count);

        // 첫 줄에 정수 R(1 ≤ R ≤ 5), C(1 ≤ C ≤ 5), K(1 ≤ K ≤ R×C)가 공백으로 구분되어 주어진다.
        // 두 번째부터 R+1번째 줄까지는 R×C 맵의 정보를 나타내는 '.'과 'T'로 구성된 길이가 C인 문자열로 이루어짐
        // ⭐ 첫 줄에 거리가 K인 가짓수를 출력해야함 ⭐

    }



}
