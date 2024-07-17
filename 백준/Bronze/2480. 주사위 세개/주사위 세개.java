import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // 세 개의 주사위 눈을 입력 받음
        int[] dice = new int[3];
        for (int i = 0; i < 3; i++) {
            dice[i] = scan.nextInt();
        }

        // 주사위 눈을 정렬하여 같은 눈이 몇 개인지 확인
        int[] count = new int[7]; // 각 눈의 개수를 저장할 배열(1~6) => 7은 길이
        for (int value : dice) {
            count[value]++;
        }

        int maxCount = 0; // 가장 많이 나온 눈의 개수
        int maxNum = 0; // 가장 많이 나온 눈
        for (int i = 1; i <= 6; i++) {
            if (count[i] >= maxCount) {
                maxCount = count[i];
                maxNum = i;
            }
        }

        int prize = 0; // 상금
        if (maxCount == 3) { // 세 개의 눈이 모두 같은 경우
            prize = 10000 + maxNum * 1000;
        } else if (maxCount == 2) { // 두 개의 눈이 같은 경우
            prize = 1000 + maxNum * 100;
        } else { // 모두 다른 경우
            prize = maxNum * 100;
        }
        System.out.println(prize);

        }
}
