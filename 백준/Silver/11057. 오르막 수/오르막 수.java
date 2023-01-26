import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static final int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10];
        Arrays.fill(dp[1], 1);
        for(int i=2; i<=n; i++){
            int sum = 0;
            dp[i][0] = dp[i-1][0];
            for(int j=0; j<10; j++){
                sum += dp[i-1][j];
                dp[i][j] = sum%DIV;
            }
        }
        int sum = 0;
        for(int i=0; i<10; i++){
            sum += dp[n][i];
        }
        System.out.println(sum%DIV);










    }
}