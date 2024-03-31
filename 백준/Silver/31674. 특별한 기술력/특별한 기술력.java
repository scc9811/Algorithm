import java.util.*;
import java.io.*;

public class Main{
    static final long MOD = (long)1e9 + 7;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long weight = arr[n-1];
        for(int i=n-2; i>=0; i--){
            weight = (weight*2 + arr[i]) % MOD;
        }

        System.out.println(weight);













    }
}
