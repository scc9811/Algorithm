import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        dp[1] = Integer.parseInt(st.nextToken());
        dp[2] = Integer.parseInt(st.nextToken());

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp1 = r + Math.min(dp[1], dp[2]);
            int tmp2 = g + Math.min(dp[0], dp[2]);
            int tmp3 = b + Math.min(dp[0], dp[1]);
            dp[0] = tmp1;
            dp[1] = tmp2;
            dp[2] = tmp3;
        }

        int res = (int)1e9;
        for(int i=0; i<3; i++){
            res = Math.min(res, dp[i]);
        }
        System.out.println(res);





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