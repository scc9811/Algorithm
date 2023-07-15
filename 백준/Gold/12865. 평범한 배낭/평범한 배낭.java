import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            dp[i] = Arrays.copyOf(dp[i-1], k+1);
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for(int j=w; j<=k; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w] + v);
            }
        }

        System.out.println(dp[n][k]);





    }


    static int[] par;
    static int find(int a) {
        if (par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a<p_b) par[p_b] = p_a;
        else par[p_a] = p_b;
    }
}