import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][m+1];

        dp[1] = Arrays.copyOf(arr[1], m+1);

        for(int i=2; i<=n; i++){
            int[] tmpArray = Arrays.copyOfRange(dp[i-1], 1, m+1);
            Arrays.sort(tmpArray);
            int minFst = tmpArray[0];
            int minSec = tmpArray[1];
            for(int j=1; j<=m; j++){
                if(minFst==dp[i-1][j]) dp[i][j] = arr[i][j] + minSec;
                else dp[i][j] = arr[i][j] + minFst;
            }
        }

        int min = (int)1e9;
        for(int i=1; i<=m; i++){
            min = Math.min(dp[n][i], min);
        }

        System.out.println(min);





    }
}
