import java.util.Arrays;
class Solution {
     public String solution(String[] cards1, String[] cards2, String[] goal) {
        if (canConstruct(cards1, cards2, goal) || canConstruct(cards2, cards1, goal)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    // 두 카드 뭉치를 동시에 고려하여 goal을 만들 수 있는지 확인하는 함수
    private boolean canConstruct(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0, idx2 = 0;
        for (String word : goal) {
            if (idx1 < cards1.length && cards1[idx1].equals(word)) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(word)) {
                idx2++;
            } else {
                return false; // goal의 단어가 두 카드 뭉치 중 어느 것에도 없는 경우
            }
        }
        return true;
    }
}