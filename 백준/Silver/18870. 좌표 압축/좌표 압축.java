import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // *** 제일 작은수가 가운데 위치해야함 + 0
    // 숫자의 개수가 홀수일경우 한개 / 짝수일경우 여러개가 될수 있음
    // 2 4 -10 4 -9   2 3 0 3 1
    /*
    1) 주어진 값들을 정렬
    2) 이진 탐색을 수행
    3) 각 값의 위치에 새로운 인덱스 부여
    4)주어진 값들을 새로운 순서로 매핑후 출력
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        long N = Long.parseLong(st.nextToken());
        int[] inputArr = new int[Integer.parseInt(String.valueOf(N))];    // 입력 받은 배열
        int[] outputArr = new int[Integer.parseInt(String.valueOf(N))];    // 입력 받은 배열
        st = new StringTokenizer(br.readLine());
        // 입력 순으로 들어감
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            inputArr[i] =  num;// 2 4 -10 4 -9
            outputArr[i] =  num;// 2 4 -10 4 -9
        }

        // 오름차순 정렬 후 map에 value값에 좌표 압축
        Arrays.sort(inputArr);
        int j=0;
        // 중복값 방지를 위한 for문
        for(int i=0; i<N; i++) {
            if(map.containsKey(inputArr[i])) continue;
            else {
                map.put(inputArr[i], j);
                j++;
            }
        }

        // 원래 받은 배열 돌리면서 ,
        // map => key값으로 value값 출력
                StringBuilder sb = new StringBuilder();

        for(int num : outputArr) {
            sb.append(map.get(num)).append(" ");
        }
            System.out.print(sb);

    }
}
