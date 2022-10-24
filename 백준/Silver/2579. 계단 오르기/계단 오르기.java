import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairs = Integer.parseInt(br.readLine());
        int[] stairs_score = new int[stairs+1];
        dp = new int[stairs+1];
        for (int i=1; i<stairs+1; i++)
            stairs_score[i] = Integer.parseInt(br.readLine());

        dp[1] = stairs_score[1];
        if(stairs>1) dp[2] = dp[1]+stairs_score[2];

        for (int i=3; i<=stairs; i++)
            dp[i] = stairs_score[i] + Math.max(dp[i - 3] + stairs_score[i - 1], dp[i - 2]);
        System.out.println(dp[stairs]);
    }
}
