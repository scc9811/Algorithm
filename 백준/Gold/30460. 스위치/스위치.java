import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[][] dp = new int[n+1][4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 스위치 활성화 남은시간 j.
        dp[1][0] = arr[1];
        dp[1][3] = arr[1]*2;

        dp[2][0] = dp[1][0] + arr[2];
        dp[2][2] = dp[1][3] + arr[2]*2;
        dp[2][3] = dp[1][0] + arr[2]*2;

        dp[3][0] = dp[2][0] + arr[3];
        dp[3][1] = dp[2][2] + arr[3]*2;
        dp[3][2] = dp[2][3] + arr[3]*2;
        dp[3][3] = dp[2][0] + 2*arr[3];


        for(int i=4; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i];
            dp[i][1] = dp[i-1][2] + 2*arr[i];
            dp[i][2] = dp[i-1][3] + 2*arr[i];
            dp[i][3] = Math.max(dp[i-1][0], dp[i-1][1]) + 2*arr[i];
//            System.out.println(Arrays.toString(dp[i]));
        }

        long res = -(long)1e17;
        for(int i=0; i<4; i++){
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);




















    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y){
        return x*y / gcd(x, y);
    }
}