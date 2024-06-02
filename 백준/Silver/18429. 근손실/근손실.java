import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    #1) 문제정리
    3대 500인 학생
    => 하루에 중량이 K만큼 감소함
        ex) k=4 , 3일 후 중량 488로 감소하게됨 , 운동을 하지 않고 가만히 있으면 매일매일 중량이 감소함

    N개의 다른 운동키트를 가지고 있음 , 하루에 1개의 키트 사용 사용할때마다 즉시 중량 증가
    이때 몇몇 운동 키트들의 중량 증가량이 같을 수 있으나, 서로 다른 운동키트로 간주함
    각각 운동키트는 N일 동안 한번씩만 사용가능

    3대 500 이상을 유지할 수 있도록 N일 간의 운동 플랜을 세우고자한다.
    운동 키트 적용 순서 가능한 경우의 수 구하기

    #2) 접근
    매일 K만큼 감소하는 중량-> 반복문사용해서 계속 감소시켜줌
    (N개의 키트) 저장해야할정보 ====> 키트번호 , 중량 증가량
    1일 지났을때 -K + n * weight  값이 500 이상인지 확인해보기
    500이상일경우 +1
    모든 경우의수를 계산해야하기 때문에 DFS 활용
    */
    static boolean[] visited; // 방문여부 체크용 배열
    static int[] array; // 키트별 중량
    static int[] order; // 운동 순서 담을 배열
    static int result;   // 결과 담을 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 계획일 수
        int K = Integer.parseInt(st.nextToken());   // 감소 중량
         // 키트번호, 증가중량
        st = new StringTokenizer(br.readLine());    // 키트번호별 중량 증가량 받기
        array = new int[N];
        order = new int[N];
        visited = new boolean[N];
        int i=0;
        while (st.hasMoreTokens()) {
            array[i] = Integer.parseInt(st.nextToken()); // 추가 증량
            i++;
        }
        dfs(N,K,0, 500);
        System.out.println(result);
    }

    // 백트래킹
    public static void dfs(int N, int K, int count, int weight) {
        // N일동안 진행되는 운동 프로그램
        // 하루에 k씩 감소 => weight = -K;
        // 1 일차 => 인덱스 0번 만큼 + 증량
        // 2 일차 => 인덱스 1번 만큼 + 증량
        if(count == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (weight + array[i] - K >= 500) { // 500이상일경우
                    dfs(N,K,count+1, weight+array[i]-K);
                }
                visited[i] = false;
            }

        }
    }
}
