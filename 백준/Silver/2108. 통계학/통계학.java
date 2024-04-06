import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    //  N개의 수를 대표하는 기본 통계값 (N은 홀수라고 가정)
    // N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());   // 게임 횟수

        int[] arr = new int[N];
        // N개의 숫자 입력 후 배열에 넣고
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // #1)  산술평균 : N개의 수들의 합을 N으로 나눈 값
        // 원소를 다 합치고 나누기 N
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
        }
        bw.write(Math.round((double) sum/N) + "\n");  // 1번 출력

        // #2) 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        //  N 을 2로 나누었을때 나오는 값의 인덱스 위치 값
        int mid = N/2;
        bw.write(arr[mid] + "\n"); // 2번 출력

        // #3) 최빈값 : N개의 수들 중 가장 많이 나타나는 값
        //             (여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력)
        // #3) 최빈값 : N개의 수들 중 가장 많이 나타나는 값
        //             (여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력)
        int mode = arr[0];
        int max = -1;
        int count = 0; // 빈도수를 저장할 변수
        boolean check = false;
        for(int i=0; i<N-1; i++) {
            if(arr[i] == arr[i+1]) {
                count++;
            } else {
                count = 0;
            }

            if(max < count) {
                max = count;
                mode = arr[i];
                check = true;
            } else if((max == count) && (check == true)) {
                mode = arr[i];
                check = false;
            }
        }
         bw.write(mode+ "\n");
        // #4) 범위 : N개의 수들 중 최댓값과 최솟값의 차이
        // (N-1 인덱스) - (0번 인덱스) 값
        bw.write((arr[N-1] - arr[0]) + "\n");


        //첫째 줄에는 산술평균을 출력 => 소수점 이하 첫째 자리에서 반올림한 값
        //둘째 줄에는 중앙값
        //셋째 줄에는 최빈값 => 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값
        //넷째 줄에는 범위를 출력

        bw.flush();
        bw.close();
    }
}
