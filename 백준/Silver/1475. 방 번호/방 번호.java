import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'0']++;
        }


        int max = (arr[6]+arr[9]-1)/2 +1;

        for(int i=0; i<10; i++){
            if(i==6 || i==9) continue;
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);










    }
}