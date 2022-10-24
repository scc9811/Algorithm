import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N+1][3];
        dp = new int[N*3+1];
        for (int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
            array[i][2] = Integer.parseInt(st.nextToken());
        }


        dp[1] = array[1][0];
        dp[2] = array[1][1];
        dp[3] = array[1][2];

        for (int i=4; i<=3*N; i+=3){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + array[i/3+1][0];
            dp[i+1] = Math.min(dp[i-1],dp[i-3]) + array[i/3+1][1];
            dp[i+2] = Math.min(dp[i-2],dp[i-3]) + array[i/3+1][2];
        }

        int min = Math.min(dp[3*N-2],dp[3*N-1]);
        min = Math.min(min,dp[3*N]);
        System.out.println(min);

    }
}
