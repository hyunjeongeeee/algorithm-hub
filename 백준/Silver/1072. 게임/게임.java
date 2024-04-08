import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1) 문제정리
    // 형택이 Spider Solitaire 게임 중 시선이 느껴지면 게임중단하고 코딩함
    //  의심을 피했다고 생각한 후 게임을 킴 -> 코딩하는 사이에 게임 실력이 눈에 띄게 향상

    // 그 이후 앞으로 모든게임에서 이김
    // But 게임 기록 삭제불가
    // 못하던 예전 기록이 지금 엄청난 게임실력 증명할 수 없다고 생각
    // 게임 횟수 : X
    // 이긴 게임 : Y (Z%)
    // Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
    // X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성

    // 2) 승률 계산방법
    //  이긴 게임 / 게임 횟수 * 100  후 소수점 버리기

    // 3) 접근방법
    // (이긴게임 + 1) 하면서 (게임 횟수 + 1) => 계속 늘려가며 Z값이 바뀌는순간 이긴게임(Y)값 확인
    // 반복문 -> Z값이 변하는순간 break;
    // Z가 절대 변하지 않는다면 -1 출력 => "게임횟수 == 이긴게임" 경우 / 99%,100%인 경우
        // => 이렇게 하니까 시간초과뜸

    // 게임횟수의 제한
    //    1 ≤ X ≤ 1,000,000,000
    //            0 ≤ Y ≤ X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = -1;   // 결과
        long X= Long.parseLong(st.nextToken()); // 게임 횟수
        long Y= Long.parseLong(st.nextToken()); // 이긴 게임
        int Z = (int)(Y*100 / X);// 승률

        long left = 1, right = X, mid = 0;
        int currentRate = 0;
        while(left <= right) {

            if(Z >= 99) { // 99% , 100% 에서는 승률 변동 불가
                answer = -1;
                break;
            }

            mid =  (left+right) / 2;    // 중간값 구하기
            currentRate = (int)((Y+mid)*100 / (X+mid));
            if(currentRate <=Z) {
                left = mid+1;
            }else {
                answer = mid;
                right = mid-1;
            }
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();

    }



}