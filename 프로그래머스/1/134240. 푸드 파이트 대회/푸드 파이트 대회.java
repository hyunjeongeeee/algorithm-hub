class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=0; i<food.length-1; i++){
            int fb = food[i+1]/2;  // 물(0)을 제외하고 한명의 선수가 먹을 음식 개수
            for(int j=0; j<fb; j++) {
                if(fb>=1) {
                    answer += (i+1);
                } else {
                    answer = "";
                }
            }
        }
        StringBuffer sb = new StringBuffer(answer);
        String answer2 = sb.reverse().toString();
        return answer + 0 + answer2;
    }
}