import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,1,2,3,4,5,7,8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'0']++;
        }

        int max = (arr[6]+arr[9]-1)/2 +1;
        for(int i : dx){
            if(arr[i]>max) max = arr[i];
        }

        System.out.println(max);










    }
}