import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int k=64; k>0; k/=2){
            if(n>=k){
                n %= k;
                count++;
            }
        }
        System.out.println(count);





    }
}
