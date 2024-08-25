import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        if (minute < 45) {
			hour = hour - 1;	// (1) 현재 시에서 -1
			minute = minute + 15;     // (2) 분 계산
			if (hour < 0) hour = 23;		// (3) 0시인 경우 23 출력되게 설정 
        } else {
            minute = minute - 45;
        } 
        System.out.println(hour + " " + minute);
    }
}