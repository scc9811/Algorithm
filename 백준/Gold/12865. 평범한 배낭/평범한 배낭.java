import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m+1];
//        Arrays.fill(dp, -1);
//        dp[0] = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(w <= m) {
                for (int j = m; j >= w; j--) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[m]);
//        int result = 0;
//        for(int i=0; i<=m; i++){
//            result = Math.max(result, dp[i]);
//        }
//        System.out.println(result);



    }
}