import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n+1];
        dp[1] = arr[1];
        for(int i=2; i<=n; i++){
            dp[i] = arr[i] + Math.min(dp[i-1], dp[i-2]);
        }

        System.out.println(Math.min(dp[n-1], dp[n]));
















    }
}
