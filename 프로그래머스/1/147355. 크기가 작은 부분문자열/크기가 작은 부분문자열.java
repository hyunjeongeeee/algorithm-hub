class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pValue = Long.parseLong(p);
                            // 경우의 수
        for(int i=0; i < t.length() - pLength + 1; i++) {
                String tstring = t.substring(i,pLength+i);  //  t의 부분문자열 substring으로 자름
                if(pValue >= Long.parseLong(tstring)) {
                    answer++;
                }
        }
        return answer;
    }
}