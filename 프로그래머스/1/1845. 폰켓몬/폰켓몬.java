import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ponketmon = map.size();
        if (ponketmon == count || ponketmon < count) answer = ponketmon;
        else answer = count;
        return answer;
    }
}