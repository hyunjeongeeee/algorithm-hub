import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        switches = new int[count];
        for (int i = 0; i < count; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender= Integer.parseInt(st.nextToken());
            int bulbNum  = Integer.parseInt(st.nextToken());
            if (gender == 1) male(bulbNum);
            else female(bulbNum);
        }
        
         for(int i = 0; i < switches.length; i++) {
             System.out.print(switches[i] + " ");
             if ((i+1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    static void female (int bulbNum) {
        // 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
        // 그 구간에 속한 스위치의 상태를 모두 바꾼다. 이때 구간에 속한 스위치 개수는 항상 홀수가 된다.
        int index = bulbNum -1;
        switches[index] = switches[index] == 0 ? 1 : 0;

        int left = index - 1;
        int right = index + 1;
            while (left >= 0 && right < switches.length && switches[left] == switches[right]) {
                switches[left] = switches[left] == 0 ? 1 : 0;
                switches[right] = switches[right] == 0 ? 1 : 0;
                left--;
                right++;
            }
    }

    static void male (int bulbNum) {
        // 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다. 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.
        // 입력받은 번호 => 3, 6, 9 ...
        // 인덱스  번호  => 2, 5, 8 ...
        for(int i = 0; i < switches.length; i++) {
            if((i + 1) % bulbNum == 0) {
                switches[i] = switches[i] == 0 ? 1 : 0;
            }
        }
    }
}
