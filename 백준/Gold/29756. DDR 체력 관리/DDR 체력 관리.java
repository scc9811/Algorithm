import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // i : gameCount, j : hp, value : score
        int[][] dp = new int[n+1][101];
        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st2.nextToken());
        dp[1][100-h] = s;
        dp[1][100] = 0;

        for(int i=2; i<=n; i++){
            s = Integer.parseInt(st1.nextToken());
            h = Integer.parseInt(st2.nextToken());
            for(int j=0; j<=100; j++){
                if(dp[i-1][j] != -1){
                    if(j+k<=100) {
                        // x
                        dp[i][j+k] = Math.max(dp[i][j+k], dp[i-1][j]);
                        // o
                        if(j+k >= h){
                            dp[i][j+k-h] = Math.max(dp[i][j+k-h], dp[i-1][j] + s);
                        }
                    }
                    else{
                        // x
                        dp[i][100] = Math.max(dp[i][100], dp[i-1][j]);
                        // o
                        dp[i][100-h] = Math.max(dp[i][100-h], dp[i-1][j] + s);
                    }
                }
            }
        }

        int max = 0;
        for(int j=0; j<=100; j++){
            max = Math.max(max, dp[n][j]);
        }
        System.out.println(max);


















    }
    static class Node{
        int s, h;
        Node(int s, int h){
            this.s = s;
            this.h = h;
        }
    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}