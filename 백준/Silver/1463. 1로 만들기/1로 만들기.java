import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        arr[1] = 0;
        if(n>1)arr[2] = 1;
        if(n>2)arr[3] = 1;
        for(int i=4; i<=n; i++){
            int min;
            if(i%2==0 && i%3==0){
                min = Math.min(arr[i/2],arr[i/3]);
                min = Math.min(min,arr[i-1]);
            }
            else if(i%2==0){
                min = Math.min(arr[i/2], arr[i-1]);
            }
            else if(i%3==0){
                min = Math.min(arr[i/3], arr[i-1]);
            }
            else{
                min = arr[i-1];
            }

            arr[i] = min+1;
        }
        System.out.println(arr[n]);





    }
}
