import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int days; int pay;
        for (int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            days = Integer.parseInt(st.nextToken());
            pay = Integer.parseInt(st.nextToken());
            if(i-1+days <= N)
                dp[i+days-1] = Math.max(dp[i+days-1],dp[i-1]+pay);

            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        System.out.println(dp[N]);

    }
}
