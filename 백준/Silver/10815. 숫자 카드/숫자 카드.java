import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(list, num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean binarySearch(int[] list, int key) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list[mid] == key) {
                return true;
            } else if (list[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
