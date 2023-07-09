import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // red, green, blue
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][3];
        int res = (int)1e9;
        for(int i=0; i<3; i++){
            if(i==0){
                dp[1][0] = (int)1e9;
                dp[1][1] = arr[0][0] + arr[1][1];
                dp[1][2] = arr[0][0] + arr[1][2];
            }
            else if(i==1){
                dp[1][0] = arr[0][1] + arr[1][0];
                dp[1][1] = (int)1e9;
                dp[1][2] = arr[0][1] + arr[1][2];
            }
            else {
                dp[1][0] = arr[0][2] + arr[1][0];
                dp[1][1] = arr[0][2] + arr[1][1];
                dp[1][2] = (int)1e9;
            }

            for(int j=2; j<n; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
            }
            
            if(i==0) res = Math.min(res, Math.min(dp[n-1][1], dp[n-1][2]));
            else if(i==1) res = Math.min(res, Math.min(dp[n-1][0], dp[n-1][2]));
            else res = Math.min(res, Math.min(dp[n-1][0], dp[n-1][1]));
        }

        System.out.println(res);


    }
}