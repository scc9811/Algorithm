import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] temp = new int[d+1];
        for(int i=1; i<=d; i++){
            temp[i] = Integer.parseInt(br.readLine());
        }
        int[][] clothes = new int[n+1][3];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            clothes[i][0] = Integer.parseInt(st.nextToken());
            clothes[i][1] = Integer.parseInt(st.nextToken());
            clothes[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[d+1][n+1];

        Arrays.fill(dp[1], -1);
        for(int i=1; i<=n; i++){
            if(clothes[i][0] <= temp[1] && clothes[i][1] >= temp[1]){
                dp[1][i] = 0;
            }
        }

        for(int i=2; i<=d; i++){
            for(int j=1; j<=n; j++){
                if(clothes[j][0] > temp[i] || clothes[j][1] < temp[i]) continue;
                for(int k=1; k<=n; k++){
                    if(dp[i-1][k] != -1) dp[i][j] = Math.max(dp[i][j],
                            dp[i-1][k] + Math.abs(clothes[j][2] - clothes[k][2]));
                }
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, dp[d][i]);
        }

        System.out.println(max);











    }
}


