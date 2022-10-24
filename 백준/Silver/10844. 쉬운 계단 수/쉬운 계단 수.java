import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] dp = new long[10];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<10; i++)
            dp[i] = 1;

        long tmp1; long tmp2;
        for (int i=1; i<N; i++){
            tmp2 = dp[0];
            dp[0] = dp[1];
            for (int j=1; j<9; j++){
                tmp1 = dp[j];
                dp[j] = (tmp2 +dp[j+1])%1000000000;
                tmp2 = tmp1;
            }
            dp[9] = tmp2;
        }




        long sum=0;
        for (int i=0; i<10; i++){
            sum = (sum+dp[i])%1000000000;
        }
        System.out.println(sum);

    }
}
