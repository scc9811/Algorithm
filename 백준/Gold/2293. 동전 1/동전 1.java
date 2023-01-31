import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int[] coins = new int[n+1];
        for(int i=1; i<=n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins,1,n+1);

        dp[1][0] = 1;
        for(int i=coins[1]; i<=k; i+=coins[1]){
            dp[1][i] = 1;
        }


        for(int i=2; i<=n; i++){
            int value = coins[i];
            dp[i] = Arrays.copyOf(dp[i-1], k+1);
            for(int j=value; j<=k; j++){
                dp[i][j] += dp[i][j-value];
            }
        }


        System.out.println(dp[n][k]);



    }
}