class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
	        
	        for(int i=0; i<parts.length; i++) {
        	int num01 = parts[i][0];	
        	int num02 = parts[i][1];	

           	while (num01 <= num02) {
        		answer += my_strings[i].charAt(num01);
        		num01++;
        	}
        	
        }
	       
	        return answer;
    }
}