import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void cantor(char[] cantorSet, int start, int length) {
        // 모든 선의 길이가 1이면 멈춘다
        if(length ==1) return;

        int middle = length/3;

        // 가운데 부분 공백으로 변환
        for(int i = start + middle; i < start + middle * 2; i++) {
                cantorSet[i] = ' ';
        }

        // 양쪽 부분 재귀
        cantor(cantorSet, start, middle);
        cantor(cantorSet, start + middle * 2, middle);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {

            int N = Integer.parseInt(line);
            int length = (int) (Math.pow(3, N)); // 3의 N제곱 =>  자바에서 거듭제곱 구하기
            char[] cantorSet = new char[length];
            for (int i = 0; i < length; i++) {
                cantorSet[i] = '-';
            }
            cantor(cantorSet, 0, length);
            System.out.println(new String(cantorSet));
        }
    }
}
