import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        if(n>1) arr[2] = 1;
        if(n>3) arr[4] = 2;
        if(n>4) arr[5] = 1;
        for(int i=5; i<n+1; i++){
            if(arr[i-2]==0){
                if(arr[i-5]==0) continue;
                arr[i] = arr[i-5]+1;
            }
            else if(arr[i-5]==0){
                arr[i] = arr[i-2]+1;
            }
            else arr[i] = Math.min(arr[i-2],arr[i-5])+1;
        }
        if(arr[n]!=0) System.out.println(arr[n]);
        else System.out.println(-1);




    }
}
