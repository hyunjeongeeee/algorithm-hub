import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        for (int i : reserve) reserveSet.add(i);
        for (int i : lost) {
            if (reserveSet.contains(i)) reserveSet.remove(i); // 본인이 여벌 체육복 사용
            else lostSet.add(i); // 실제 체육복이 필요한 학생
        }
        for (int i : reserveSet) {
            if (lostSet.contains(i - 1)) lostSet.remove(i - 1); // 앞번호 학생에게 빌려줌
            else if (lostSet.contains(i + 1)) lostSet.remove(i + 1); // 뒷번호 학생에게 빌려줌
        }
        return n - lostSet.size();
    }
}
