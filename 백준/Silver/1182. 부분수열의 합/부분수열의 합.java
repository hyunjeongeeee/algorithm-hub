import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
        static int N;
        static int S;
        static int[] arr;
        static int count = 0;
    public static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S)
                count++;
            return;
        }
        // 현재 인덱스 +
        dfs(index + 1, sum + arr[index]);
        // 현재 인덱스 -
        dfs(index + 1, sum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N]; // N개의 정수 담아주기

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 공집합  빼주기
        if (S == 0) {
            System.out.println(count - 1);
            return;
        }
        System.out.println(count);

    }
}
