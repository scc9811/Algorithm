import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = new int[200000];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- >0){
            int n = Integer.parseInt(br.readLine());
            int[] firstLine = new int[n];
            int[] secondLine = new int[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++){
                firstLine[i] = Integer.parseInt(st1.nextToken());
                secondLine[i] = Integer.parseInt(st2.nextToken());
            }



            dp[0] = firstLine[0];
            dp[1] = secondLine[0];

            if (n>1){
                dp[2] = dp[1]+firstLine[1];
                dp[3] = dp[0]+secondLine[1];
            }
            for (int i=2; i<n; i++){
                dp[2*i] = Math.max(dp[2*i-1],dp[2*i-3]) + firstLine[i];
                dp[2*i+1] = Math.max(dp[2*i-2],dp[2*i-4]) + secondLine[i];
            }

            System.out.println(Math.max(dp[2*n-1],dp[2*n-2]));




        }






    }
}
