class Solution {
     public static long[] solution(int x, int n) {
	        long[] answer = new long[n];
	        long sum = 0;
	
	        for(int i=0; i<n; i++) {
	        	sum += x;
	        	for(int j=0; j<=i; j++) {
	        		answer[i] = sum;
	        	}
	        	
	        }
	       
	        return answer;
	    }
}