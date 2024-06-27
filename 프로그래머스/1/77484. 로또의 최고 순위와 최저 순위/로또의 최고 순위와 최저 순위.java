import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0; // 0의 개수

        // 0의 개수 세기
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int count = 0;  // 당첨 번호와 일치하는 번호
        
        for (int lottoNum : lottos) {
            for (int winNum : win_nums) {
                if (lottoNum == winNum) {
                    count++;
                    break; // 일치하는 번호를 찾았으면 다음으로 넘어감
                }
            }
        }

        int highRank = zeroCount + count;
        int lowRank = count;
        
        // 순위 구하기
        answer[0] = ranking(highRank);
        answer[1] = ranking(lowRank);
       
        return answer;
    }

    public int ranking(int rank) {
        switch (rank) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}