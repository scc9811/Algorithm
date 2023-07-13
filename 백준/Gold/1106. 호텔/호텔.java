import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][c+101];
        int[][] arr = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int cost = arr[1][0];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], (int)1e9);
            dp[i][0] = 0;
        }
        for(int i=arr[1][1]; i<=c+100; i+=arr[1][1]){
            dp[1][i] = cost;
            cost += arr[1][0];
        }


        for(int i=2; i<=n; i++){
            dp[i] = Arrays.copyOf(dp[i-1], c+101);
            cost = arr[i][0];
            int p = arr[i][1];
            for(int j=p; j<=c+100; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i][j-p] + cost);

            }
        }

//
//        for(int i=1; i<=n; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int res = (int)1e9;
        for(int j=c; j<=c+100; j++){
            res = Math.min(dp[n][j], res);
        }
        System.out.println(res);


    }
}