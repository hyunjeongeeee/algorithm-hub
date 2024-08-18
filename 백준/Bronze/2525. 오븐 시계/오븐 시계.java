import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        
        int input = Integer.parseInt(br.readLine());
        int time = (hours * 60) + minutes + input;
        hours = (time / 60) % 24;
        minutes = time % 60;

        System.out.println(hours + " " + minutes);
    }
}