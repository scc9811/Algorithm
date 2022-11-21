import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='H') arr[0]++;
            else if(s.charAt(i)=='I') arr[1]++;
            else if(s.charAt(i)=='A') arr[2]++;
            else if(s.charAt(i)=='R') arr[3]++;
            else if(s.charAt(i)=='C') arr[4]++;
        }

        int min = 1000000;
        for(int i=0; i<5; i++){
            min = Math.min(min, arr[i]);
        }
        System.out.println(min);







    }
}
