import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] dp = new long[91];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long oneCount = 0;
        long zeroCount = 0;
        dp[1] = 1;
        oneCount++;
        for (int i=2; i<=N; i++){
            long tmp = zeroCount;
            zeroCount = zeroCount + oneCount;
            oneCount = tmp;
            dp[i] = oneCount + zeroCount;
        }
        System.out.println(dp[N]);

    }
}
