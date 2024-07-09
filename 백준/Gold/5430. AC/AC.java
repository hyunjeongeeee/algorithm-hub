import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();   // 실행할 함수
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            // "[]" 제거 후 -> split(",") 문자열 나누기
            String[] arr = input.substring(1,input.length()-1).split(",");

            bw.write(solution(p, arr, n));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solution(String p, String[] arr, int n) {

        int left = 0;
        int right = n;
        boolean isReverse = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {

            if (p.charAt(i) == 'R') {  // R 실행
                if (!isReverse) isReverse = true;
                else isReverse = false;
            }

            if (p.charAt(i) == 'D') {  // D 실행
                if (!isReverse) left++;
                else right--;
            }

            if (left > right) {
                return "error\n";
            }

        }

        sb.append("[");
        if (isReverse) {
            for (int i = right-1; i >= left; i--) {
                sb.append(arr[i]);
                if (i != left) sb.append(",");
            }
        } else {
            for (int i = left; i <= right-1; i++) {
                sb.append(arr[i]);
                if (i != right - 1) sb.append(",");
            }
        }
        sb.append("]\n");

        return sb.toString();
    }

}