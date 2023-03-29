import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d = 0;
        int p = 0;
        for(int i=0; i<n; i++){
            char c = br.readLine().charAt(0);
            if(c=='D') d++;
            else p++;
            if(d>=p+2 || p>=d+2) break;
        }
        System.out.printf("%d:%d",d, p);
        



    }
}