import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];

        for (int i = 1; i <= 30; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr);

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = 0;
        }
        
        for (int i = 0; i <= 30; i++) {
            if (arr[i] != 0) System.out.println(arr[i]);

        }
        
    }
}