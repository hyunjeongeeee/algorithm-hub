import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] scaleC = {1,2,3,4,5,6,7,8};   // 원본 배열
        int[] scaleC2 = {8,7,6,5,4,3,2,1};   // 내림차순 배열
        int[] inputArr = new int[8];    // 입력 받은 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k=0;
        while(st.hasMoreTokens()) { // 입력받은 숫자 저장
           inputArr[k] = Integer.parseInt(st.nextToken());
           k++;
        }

        // C 스케일과 동일한지 확인
        if (Arrays.equals(scaleC,inputArr)) bw.write("ascending");
        else if(Arrays.equals(scaleC2,inputArr)) bw.write("descending");
        else bw.write("mixed");

        bw.flush();
        bw.close();
        br.close();

        }
    }
