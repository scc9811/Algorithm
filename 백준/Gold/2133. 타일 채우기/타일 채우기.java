import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        arr[0] = 1;
        if(n>=2) arr[2] = 3;
        if(n>=4) arr[4] = 11;
        for(int i=6; i<=n; i+=2){
            arr[i] = arr[i-2]*3;
            for(int j=4; j<=i; j+=2){
                arr[i] += arr[i-j]*2;
            }
        }
        System.out.println(arr[n]);



    }
}