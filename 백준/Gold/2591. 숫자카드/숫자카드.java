import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long[] dp = new long[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int k = Integer.parseInt(s.substring(i - 1, i + 1));
            if(k!=10 && k!=20 && k!=30) dp[i] += dp[i-1];
            if (k >= 10 && k <= 34) {
                if (i == 1) dp[i]++;
                else dp[i] += dp[i - 2];
            }
        }
        System.out.println(dp[s.length() - 1]);


    }
}


