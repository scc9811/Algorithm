import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = new int[500];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = Integer.parseInt(br.readLine());
        int i = 2;
        n--;
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp2 = dp[0];
            dp[0] += Integer.parseInt(st.nextToken());
            for (int j=1; j<i; j++){
                int tmp = dp[j];
                dp[j] = Math.max(tmp2,dp[j]) + Integer.parseInt(st.nextToken());
                tmp2 = tmp;
            }
            i++;
        }
        int max = dp[0];
        for (int j =1; j<i-1; j++){
            max = Math.max(max,dp[j]);
        }
        System.out.println(max);


    }
}
