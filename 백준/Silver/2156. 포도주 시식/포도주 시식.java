import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i=0; i<n; i++) array[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[n];


        dp[0] = array[0];
        if (n > 1) dp[1] = dp[0] + array[1];
        if (n > 2) dp[2] = Math.max(array[0], array[1]) + array[2];
        if (n > 3) dp[3] = Math.max(dp[1], dp[0] + array[2]) + array[3];
        for (int i = 4; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], Math.max(dp[i - 4], dp[i - 3]) + array[i - 1]) + array[i];
        }

        if (n==1) System.out.println(dp[0]);
        else if (n==2) System.out.println(Math.max(dp[0],dp[1]));
        else System.out.println(Math.max(dp[n - 2], dp[n - 1]));


    }
}
