import java.util.Scanner;

class Solution {
   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt(); // 가로
	        int b = sc.nextInt(); // 세로

	        
	        for(int j=0; j<b; j++) {
	        	System.out.print("*");
	        	
		        for(int i=1; i<a; i++) {
		        	System.out.print("*");
		        }
		        System.out.println();
	        }
	    
	    }
}