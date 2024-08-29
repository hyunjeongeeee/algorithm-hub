import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static char[][] floor;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        floor = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }

        int count = 0;

        // 가로 방향 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-' && !visited[i][j]) {
                    count++;
                    // 가로로 연속된 '-'를 모두 방문 처리
                    while (j < M && floor[i][j] == '-') {
                        visited[i][j] = true;
                        j++;
                    }
                }
            }
        }

        // 세로 방향 탐색
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (floor[i][j] == '|' && !visited[i][j]) {
                    count++;
                    // 세로로 연속된 '|'를 모두 방문 처리
                    while (i < N && floor[i][j] == '|') {
                        visited[i][j] = true;
                        i++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    /*
     '-' 는 가로 인덱스랑 같은지 비교 => x값 고정
    0 0 [x][y]
    0 1 [x][y + 1]
    0 2 [x][y + 2]
    0 3
    ...
    ----------------------------
     '|' 는 세로 인덱스랑 같은지 비교 => y값 고정
    0 0 [x][y]
    1 0 [x + 1][y]
    2 0 [x + 2][y]
    3 0
    ...

    같은 무늬일 경우 [인덱스 +1] 반복해서 다음 요소와 같은지 다른지 확인 (다른 무늬가 나올때 까지 반복 탐색)
    다른경우 반복문 stop => 타일갯수 count + 1 => 다음 인덱스 탐색
    */
}
